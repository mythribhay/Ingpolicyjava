package com.insurance.hcis.service;

import com.insurance.hcis.dto.PolicyResponse;
import com.insurance.hcis.exception.InvalidPolicyException;

// TODO: Auto-generated Javadoc
/**
 * The Interface PolicyService.
 */
public interface PolicyService {

	/**
	 * Verify andget policy.
	 *
	 * @param policyId the policy id
	 * @return the policy response
	 * @throws InvalidPolicyException the invalid policy exception
	 */
	public PolicyResponse verifyAndgetPolicy(Integer policyId) throws InvalidPolicyException;

}
