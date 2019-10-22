package com.insurance.hcis.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.insurance.hcis.dto.HospitalResponse;
import com.insurance.hcis.entity.Hospital;
import com.insurance.hcis.repository.HospitalRepository;

@RunWith(MockitoJUnitRunner.class)
public class HospitalsServiceTest {

	@Mock
	HospitalRepository hospitalRepository;

	@InjectMocks
	HospitalService hospitalService;

	List<Hospital> hospitals;

	@Before
	public void setup() {
		Hospital hospital1 = new Hospital();
		hospital1.setHospitalId(1);
		hospital1.setHospitalName("Appolo");
		hospitals.add(hospital1);
		Hospital hospital2 = new Hospital();
		hospital1.setHospitalId(2);
		hospital1.setHospitalName("kamineni");
		hospitals.add(hospital2);

	}

	@Test
	public void testFetchBooks() {
		/*
		 * Mockito.when(hospitalRepository.findAll()).thenReturn(hospitals);
		 * Optional<List<HospitalResponse>> hospitalO =
		 * hospitalService.getAllHospitals(); assertNotNull(hospitalO);
		 */

	}

}
