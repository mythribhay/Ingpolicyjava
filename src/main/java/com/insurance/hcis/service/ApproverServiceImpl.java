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

		if (!(listPolicyClaim.isPresent())) {
			throw new CommonException(ApplicationConstants.NO_CLAIMS_FOUND);
		}

		List<PolicyClaim> policyClaim = listPolicyClaim.get();

		Optional<List<ResponsePolicyClaim>> listResponsePolicyClaimDto;
		List<ResponsePolicyClaim> listOfResponsePolicyClaim = new ArrayList<>();

		policyClaim.forEach(responsePolicyClaimDb -> {

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

	@Override
	public ResponseClaimApproveDto approveClaim(RequestClaimApproveDto requestClaimApproveDto) throws CommonException {

		if (requestClaimApproveDto == null) {
			throw new CommonException(ApplicationConstants.INVALID_APPROVAL_DETAILS);
		}

		PolicyClaim responsePolicy = policyClaimRepository.findByApproverIdAndClaimId(
				requestClaimApproveDto.getApproverId(), requestClaimApproveDto.getClaimId());

		if (responsePolicy == null) {
			throw new CommonException(ApplicationConstants.NO_CLAIMS_FOUND);
		}

		if (!(requestClaimApproveDto.getApproverId() == 1001 || requestClaimApproveDto.getApproverId() == 2001)) {
			throw new CommonException(ApplicationConstants.INVALID_APPROVER_ID);
		}

		if (!(requestClaimApproveDto.getLevelOneStatus().equalsIgnoreCase(ApprovalStatus.APPROVED)
				|| requestClaimApproveDto.getLevelOneStatus().equalsIgnoreCase(ApprovalStatus.REJECTED))) {
			throw new CommonException(ApplicationConstants.INVALID_LEVEL_ONE_STATUS);
		}

		if (!(requestClaimApproveDto.getLevelTwoStatus().equalsIgnoreCase(ApprovalStatus.LEVEL_ONE_COMPLETE)
				|| requestClaimApproveDto.getLevelTwoStatus().equalsIgnoreCase(ApprovalStatus.LEVEL_ONE_NOTCOMPLETE))) {
			throw new CommonException(ApplicationConstants.INVALID_LEVEL_TWO_STATUS);
		}

		ResponseClaimApproveDto responseClaimApproveDto = new ResponseClaimApproveDto();

		if (requestClaimApproveDto.getApproverId() == 1001
				&& requestClaimApproveDto.getLevelOneStatus().equalsIgnoreCase(ApprovalStatus.APPROVED)

				&& requestClaimApproveDto.getLevelTwoStatus().equalsIgnoreCase(ApprovalStatus.LEVEL_ONE_COMPLETE)) {
			responsePolicy.setStatus(ApprovalStatus.LEVEL_ONE_APPROVED);
			responsePolicy.setApprover1Comment(requestClaimApproveDto.getComments());
			responseClaimApproveDto.setApprovedLevelStatus(ApprovalStatus.APPROVED);
			policyClaimRepository.save(responsePolicy);
		}
		if (requestClaimApproveDto.getApproverId() == 1001
				&& requestClaimApproveDto.getLevelOneStatus().equalsIgnoreCase(ApprovalStatus.APPROVED)
				&& requestClaimApproveDto.getLevelTwoStatus().equalsIgnoreCase(ApprovalStatus.LEVEL_ONE_NOTCOMPLETE)) {
			responsePolicy.setStatus(ApprovalStatus.LEVEL_TWO_PENDING);
			responsePolicy.setApproverId(2);
			responsePolicy.setApprover1Comment(requestClaimApproveDto.getComments());
			responseClaimApproveDto.setApprovedLevelStatus(ApprovalStatus.APPROVED);
			policyClaimRepository.save(responsePolicy);
		}
		if (requestClaimApproveDto.getApproverId() == 2001
				&& requestClaimApproveDto.getLevelOneStatus().equalsIgnoreCase(ApprovalStatus.APPROVED)

				&& requestClaimApproveDto.getLevelTwoStatus().equalsIgnoreCase(ApprovalStatus.LEVEL_ONE_COMPLETE)) {
			responsePolicy.setStatus(ApprovalStatus.LEVEL_TWO_APPROVED);
			responseClaimApproveDto.setApprovedLevelStatus(ApprovalStatus.APPROVED);
			policyClaimRepository.save(responsePolicy);
		}

		return responseClaimApproveDto;
	}

}
