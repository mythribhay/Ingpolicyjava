package com.insurance.hcis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.hcis.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
