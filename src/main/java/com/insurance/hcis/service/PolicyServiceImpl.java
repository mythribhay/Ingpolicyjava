package com.insurance.hcis.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.hcis.dto.PolicyResponse;
import com.insurance.hcis.entity.Policy;
import com.insurance.hcis.exception.InvalidPolicyException;
import com.insurance.hcis.repository.PolicyRepository;
import com.insurance.hcis.util.ApplicationConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * The class PolicyService which verifies the policy is valid and expired or not.
 * @author sharath vemperala
 */
@Service
@Slf4j
public class PolicyServiceImpl implements PolicyService {

	/** The policy repository. */
	@Autowired
	PolicyRepository policyRepository;
	
	/**
	 * The method PolicyService which verifies the policy is valid and expired or not and gets the policy.
	 *
	 * @param policyId the policy id
	 * @return the policy response
	 * @throws InvalidPolicyException the invalid policy exception if policy is not valid or expired
	 */
	@Override
	public PolicyResponse verifyAndgetPolicy(Integer policyId) throws InvalidPolicyException {
		log.info("Enter PolicyServiceImpl:verifyAndgetPolicy");

		Optional<Policy> policyO = policyRepository.findById(policyId);
		/**
		 * throws InvalidPolicyException the invalid policy exception if policy is not valid
		 */
		if(!policyO.isPresent()) {
			 throw new InvalidPolicyException(ApplicationConstants.INVALID_POLICY);
		}
		
		Policy policy = policyO.get();
		LocalDate endDate = policy.getEndDate();
		LocalDate currentDate = LocalDate.now();
		/**
		 * throws InvalidPolicyException the invalid policy exception if policy is expired
		 */
		if(endDate.compareTo(currentDate) < 0) {
			throw new InvalidPolicyException(ApplicationConstants.VERIFICATION_FAILED);
		}
		PolicyResponse policyResponse = new PolicyResponse();
		BeanUtils.copyProperties(policy, policyResponse);
		
		return policyResponse;
	}

}

