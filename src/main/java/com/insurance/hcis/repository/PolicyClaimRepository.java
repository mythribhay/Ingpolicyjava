package com.insurance.hcis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.hcis.entity.PolicyClaim;

/**
 * 
 * @author Manisha
 * @apiNote This repository is to interact with policy claim entity.
 *
 */
@Repository
public interface PolicyClaimRepository extends JpaRepository<PolicyClaim, Integer> {

}
