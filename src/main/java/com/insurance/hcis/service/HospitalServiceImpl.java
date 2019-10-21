package com.insurance.hcis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurance.hcis.dto.HospitalResponse;
import com.insurance.hcis.entity.Hospital;
import com.insurance.hcis.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class HospitalServiceImpl.
 * 
 * @author sharath vemperala
 */
@Service
@Slf4j
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	HospitalRepository hospitalRepository;

	/**
	 * Gets the all hospitals.
	 *
	 * @return the all hospitalResponse
	 */
	@Override
	public Optional<List<HospitalResponse>> getAllHospitals() {
		log.info("Enter HospitalServiceImpl:getAllHospitals()");
		List<Hospital> hospitals = hospitalRepository.findAll();
		List<HospitalResponse> hospitalListResponseDto = new ArrayList<>();
		hospitals.forEach(hospital -> {
			HospitalResponse hospitalResponse = new HospitalResponse();
			BeanUtils.copyProperties(hospital, hospitalResponse);
			hospitalListResponseDto.add(hospitalResponse);
		});
		return Optional.of(hospitalListResponseDto);
	}

}