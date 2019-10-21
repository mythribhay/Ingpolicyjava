package com.insurance.hcis.service;

import java.util.List;
import java.util.Optional;

import com.insurance.hcis.dto.HospitalResponse;

/**
 * The Interface HospitalService.
 */
public interface HospitalService {

	/**
	 * Gets the all hospitals.
	 *
	 * @return the all hospitals
	 */
	public Optional<List<HospitalResponse>> getAllHospitals();

}
