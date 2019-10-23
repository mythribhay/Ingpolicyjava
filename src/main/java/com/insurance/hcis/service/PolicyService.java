package com.insurance.hcis.service;

import com.insurance.hcis.dto.PolicyResponse;
import com.insurance.hcis.exception.InvalidPolicyException;

/**
 * The Interface PolicyService which verifies the policy is valid and expired or not.
 * @author sharath vemperala
 */
public interface PolicyService {

	/**
	 * Verify and get policy.
	 *
	 * @param policyId the policy id
	 * @return the policy response
	 * @throws InvalidPolicyException the invalid policy exception
	 */
	public PolicyResponse verifyAndgetPolicy(Integer policyId) throws InvalidPolicyException;

}
