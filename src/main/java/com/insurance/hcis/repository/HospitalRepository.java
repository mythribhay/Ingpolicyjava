package com.insurance.hcis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.hcis.entity.Hospital;

/**
 * The Interface HospitalRepository.
 * @author sharath vemperala
 */
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
