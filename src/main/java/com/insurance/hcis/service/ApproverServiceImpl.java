/**
 * 
 */
package com.insurance.hcis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.hcis.dto.RequestClaimApproveDto;
import com.insurance.hcis.dto.ResponseClaimApproveDto;
import com.insurance.hcis.dto.ResponsePolicyClaim;
import com.insurance.hcis.entity.Policy;
import com.insurance.hcis.entity.PolicyClaim;
import com.insurance.hcis.exception.CommonException;
import com.insurance.hcis.repository.PolicyClaimRepository;
import com.insurance.hcis.repository.PolicyRepository;
import com.insurance.hcis.util.ApplicationConstants;
import com.insurance.hcis.util.ApprovalStatus;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SubhaMaheswaran
 * 
 * @Description This class is used for to do the getClaim and approveClaim
 *              operations
 */
@Service
@Slf4j
public class ApproverServiceImpl implements ApproverService {

	@Autowired
	PolicyClaimRepository policyClaimRepository;

	@Autowired
	PolicyRepository policyRepository;

	/**
	 * @Description This method is used for get claims
	 * @param approverId,status
	 * @return List<ResponsePolicyClaim>
	 * @exception NO_CLAIMS_FOUND
	 */
	public Optional<List<ResponsePolicyClaim>> getClaims(Integer approverId, String status) throws CommonException {
		log.info(":: Enter into ApproverServiceImpl--------::getClaims()");
		Optional<List<PolicyClaim>> listPolicyClaim = policyClaimRepository.findByApproverIdAndStatus(approverId,
				status);
		/**
		 * @Description checking policyList is present or not
		 * @exception NO_CLAIMS_FOUND
		 */
		if (!(listPolicyClaim.isPresent())) {
			throw new CommonException(ApplicationConstants.NO_CLAIMS_FOUND);
		}
		List<PolicyClaim> policyClaim = listPolicyClaim.get();
		Optional<List<ResponsePolicyClaim>> listResponsePolicyClaimDto;
		List<ResponsePolicyClaim> listOfResponsePolicyClaim = new ArrayList<>();

		policyClaim.stream().forEach(responsePolicyClaimDb -> {

			Policy responsePolicy = policyRepository.findByDiagnosisAndAilmentAndPolicyId(
					responsePolicyClaimDb.getDiagnosis(), responsePolicyClaimDb.getAilment(),
					responsePolicyClaimDb.getPolicyId());
			ResponsePolicyClaim responsePolicyClaim = new ResponsePolicyClaim();
			BeanUtils.copyProperties(responsePolicyClaimDb, responsePolicyClaim);
			responsePolicyClaim.setClaimAmount(responsePolicy.getClaimAmount());
			listOfResponsePolicyClaim.add(responsePolicyClaim);
		});

		listResponsePolicyClaimDto = Optional.of(listOfResponsePolicyClaim);
		return listResponsePolicyClaimDto;
	}

	/**
	 * <<<<<<< HEAD
	 * 
	 * @Description This method is used for get claims =======
	 * @Description This method is used for approve claim >>>>>>>
	 *              e799c3a4c526962160d781be7d6ba1534e2ce37d
	 * @param requestClaimApproveDto
	 * @return ResponseClaimApproveDto
	 * @exception NO_CLAIMS_FOUND,INVALID_APPROVAL_DETAILS,INVALID_APPROVER_ID
	 */

	@Override
	public ResponseClaimApproveDto approveClaim(RequestClaimApproveDto requestClaimApproveDto) throws CommonException {
		log.info(":: Enter into ApproverServiceImpl--------::approveClaim()");

		/**
		 * @Description checking the request is null
		 * @exception INVALID_APPROVAL_DETAILS
		 */

		if (requestClaimApproveDto == null) {
			throw new CommonException(ApplicationConstants.INVALID_APPROVAL_DETAILS);
		}
		/**
		 * @Description Checking the approverId is valid
		 * @exception INVALID_APPROVER_ID
		 */
		if (!(requestClaimApproveDto.getApproverId() == 1001 || requestClaimApproveDto.getApproverId() == 2001)) {
			throw new CommonException(ApplicationConstants.INVALID_APPROVER_ID);
		}
		/**
		 * @Description Checking the level one status is valid
		 * @exception INVALID_LEVEL_ONE_STATUS
		 */
		if (!(requestClaimApproveDto.getLevelOneStatus().equalsIgnoreCase(ApprovalStatus.APPROVED)
				|| requestClaimApproveDto.getLevelOneStatus().equalsIgnoreCase(ApprovalStatus.REJECTED))) {
			throw new CommonException(ApplicationConstants.INVALID_LEVEL_ONE_STATUS);
		}
		/**
		 * @Description Checking the level two status is valid
		 * @exception INVALID_LEVEL_TWO_STATUS
		 */
		if (!(requestClaimApproveDto.getLevelTwoStatus().equalsIgnoreCase(ApprovalStatus.LEVEL_ONE_COMPLETE)
				|| requestClaimApproveDto.getLevelTwoStatus().equalsIgnoreCase(ApprovalStatus.LEVEL_ONE_NOTCOMPLETE))) {
			throw new CommonException(ApplicationConstants.INVALID_LEVEL_TWO_STATUS);
		}

		Optional<PolicyClaim> responsePolicy = policyClaimRepository.findByApproverIdAndClaimId(
				requestClaimApproveDto.getApproverId(), requestClaimApproveDto.getClaimId());
		/**
		 * @Description Checking the policy is present or not
		 * @exception NO_CLAIMS_FOUND
		 */
		if (!(responsePolicy.isPresent())) {
			throw new CommonException(ApplicationConstants.NO_CLAIMS_FOUND);
		}
		PolicyClaim updatedPolicy;
		updatedPolicy = responsePolicy.get();
		ResponseClaimApproveDto responseClaimApproveDto = new ResponseClaimApproveDto();
		/**
		 * @Description approve the claim in the level one
		 */
		if (requestClaimApproveDto.getApproverId() == 1001
				&& requestClaimApproveDto.getLevelOneStatus().equalsIgnoreCase(ApprovalStatus.APPROVED)

				&& requestClaimApproveDto.getLevelTwoStatus().equalsIgnoreCase(ApprovalStatus.LEVEL_ONE_COMPLETE)) {
			updatedPolicy.setStatus(ApprovalStatus.LEVEL_ONE_APPROVED);
			responseClaimApproveDto.setApprovedLevelStatus(ApprovalStatus.APPROVED);
			policyClaimRepository.save(updatedPolicy);
		}
		/**
		 * @Description approve the claim in the level one but moved to level two
		 *              approval
		 */
		if (requestClaimApproveDto.getApproverId() == 1001
				&& requestClaimApproveDto.getLevelOneStatus().equalsIgnoreCase(ApprovalStatus.APPROVED)
				&& requestClaimApproveDto.getLevelTwoStatus().equalsIgnoreCase(ApprovalStatus.LEVEL_ONE_NOTCOMPLETE)) {
			updatedPolicy.setStatus(ApprovalStatus.LEVEL_TWO_PENDING);
			updatedPolicy.setApproverId(2001);
			responseClaimApproveDto.setApprovedLevelStatus(ApprovalStatus.APPROVED);
			policyClaimRepository.save(updatedPolicy);
		}
		/**
		 * @Description approve the claim in the level two
		 */
		if (requestClaimApproveDto.getApproverId() == 2001
				&& requestClaimApproveDto.getLevelOneStatus().equalsIgnoreCase(ApprovalStatus.APPROVED)

				&& requestClaimApproveDto.getLevelTwoStatus().equalsIgnoreCase(ApprovalStatus.LEVEL_ONE_COMPLETE)) {
			updatedPolicy.setStatus(ApprovalStatus.LEVEL_TWO_APPROVED);
			responseClaimApproveDto.setApprovedLevelStatus(ApprovalStatus.APPROVED);
			policyClaimRepository.save(updatedPolicy);
		}

		return responseClaimApproveDto;
	}

}
