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
 * @author SubhaMaheswaran
 *
 */
@Repository
public interface PolicyClaimRepository extends JpaRepository<PolicyClaim, Integer> {

	/**
	 * @param approverId
	 * @param status
	 * @return
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
