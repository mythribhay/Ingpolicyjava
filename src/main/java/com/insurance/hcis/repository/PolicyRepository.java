/**
 * 
 */
package com.insurance.hcis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.hcis.entity.Policy;

/**
 * @author SubhaMaheswaran
 *
 */
public interface PolicyRepository extends JpaRepository<Policy, Integer> {

	/**
	 * @param diagnosis
	 * @param ailment
	 * @param policyId
	 * @return Policy
	 */
	Policy findByDiagnosisAndAilmentAndPolicyId(String diagnosis, String ailment, Integer policyId);

}
