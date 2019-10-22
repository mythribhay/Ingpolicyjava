package com.insurance.hcis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.hcis.dto.ClaimRequestDto;
import com.insurance.hcis.dto.ClaimResponseDto;
import com.insurance.hcis.entity.PolicyClaim;
import com.insurance.hcis.repository.PolicyClaimRepository;
import com.insurance.hcis.util.ApplicationConstants;

import lombok.extern.slf4j.Slf4j;
/**
 * @author Manisha Yadav
 * Description- this class is used to submit the claim details to health insurance claim system.
 *
 */
@Service
@Slf4j
public class PolicyClaimServiceImpl implements PolicyClaimService{

	@Autowired
	PolicyClaimRepository policyClaimRepository;
	@Autowired
	ApplicationConstants applicationConstants;
	
	/**
	 * @param- claimRequestDto
	 * @return- ClaimResponseDto
	 * This method is used to submit the claim details by the user.
	 */
	@Override
	public ClaimResponseDto claimPolicy(ClaimRequestDto claimRequestDto) {

		log.info(":: Enter into PolicyClaimServiceImpl--------::claimPolicy()");
		PolicyClaim policyClaim = new PolicyClaim();
		policyClaim.setAdmissionDate(claimRequestDto.getAdmissionDate());
		policyClaim.setAilment(claimRequestDto.getAilment());
		policyClaim.setApproverId(ApplicationConstants.FIRST_APPROVER_ID);
		policyClaim.setApprover1Comment(claimRequestDto.getApprover1Comment());
		policyClaim.setApprover2Comment(claimRequestDto.getApprover2Comment());
		policyClaim.setClaimDate(claimRequestDto.getClaimDate());
		policyClaim.setDiagnosis(claimRequestDto.getDiagnosis());
		policyClaim.setDischargeDate(claimRequestDto.getDischargeDate());
		policyClaim.setHospitalName(claimRequestDto.getHospitalName());
		policyClaim.setPolicyId(claimRequestDto.getPolicyId());
		policyClaim.setRequestedClaimAmount(claimRequestDto.getRequestedClaimAmount());
		policyClaim.setStatus(claimRequestDto.getStatus());
		policyClaimRepository.save(policyClaim);
		Integer claimId = policyClaim.getClaimId();
		ClaimResponseDto claimResponseDto = new ClaimResponseDto();
		claimResponseDto.setClaimId(claimId);
		claimResponseDto.setMessage(ApplicationConstants.CLAIM_POLICY_SUCESS_MESSAGE);
		claimResponseDto.setStatusCode(ApplicationConstants.SUCESS_STATUS_CODE);
		return claimResponseDto;
	}

}
