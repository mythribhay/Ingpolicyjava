
/**
 * 
 */
package com.insurance.hcis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.hcis.entity.PolicyClaim;

/**
 * 
 * 
 * @author Manisha
 * @apiNote This repository is to interact with policy claim entity. >>>>>>>
 *          ef728349758d420571cbaaa9c26d6d380adc21b3
 *
 */
@Repository
public interface PolicyClaimRepository extends JpaRepository<PolicyClaim, Integer> {

	/**
	 * @param approverId
	 * @param status
	 * @return List<PolicyClaim>
	 */
	Optional<List<PolicyClaim>> findByApproverIdAndStatus(Integer approverId, String status);

	/**
	 * @param approverId
	 * @param claimId
	 * @param approverId2
	 * @return PolicyClaim
	 */
	PolicyClaim findByApproverIdAndClaimId(Integer approverId, Integer claimId);

}
