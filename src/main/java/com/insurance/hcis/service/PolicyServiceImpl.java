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

/**
 * The Class PolicyServiceImpl.
 * @author sharath vemperala
 */
@Service
public class PolicyServiceImpl implements PolicyService {

	/** The policy repository. */
	@Autowired
	PolicyRepository policyRepository;
	
	/**
	 * Verify and get policy.
	 *
	 * @param policyId the policy id
	 * @return the policy response
	 * @throws InvalidPolicyException the invalid policy exception
	 */
	@Override
	public PolicyResponse verifyAndgetPolicy(Integer policyId) throws InvalidPolicyException {
		Optional<Policy> policyO = policyRepository.findById(policyId);
		if(!policyO.isPresent()) {
			 throw new InvalidPolicyException(ApplicationConstants.INVALID_POLICY);
		}
		Policy policy = policyO.get();
		LocalDate endDate = policy.getEndDate();
		LocalDate currentDate = LocalDate.now();
		if(endDate.compareTo(currentDate) < 0) {
			throw new InvalidPolicyException(ApplicationConstants.VERIFICATION_FAILED);
		}
		PolicyResponse policyResponse = new PolicyResponse();
		BeanUtils.copyProperties(policy, policyResponse);
		
		return policyResponse;
	}

}

