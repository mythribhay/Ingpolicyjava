package com.insurance.hcis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.hcis.entity.Hospital;

/**
 * The Interface HospitalRepository.
 * @author sharath vemperala
 */
@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
