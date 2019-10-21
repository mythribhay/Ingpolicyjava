package com.insurance.hcis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.hcis.entity.Policy;

/**
 * The Interface PolicyRepository.
 * @author sharath vemperala
 */
public interface PolicyRepository extends JpaRepository<Policy, Integer> {

}
