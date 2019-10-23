package com.insurance.hcis.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.insurance.hcis.dto.HospitalResponse;
import com.insurance.hcis.dto.HospitalResponseDto;
import com.insurance.hcis.dto.PolicyResponse;
import com.insurance.hcis.entity.Hospital;
import com.insurance.hcis.exception.InvalidPolicyException;
import com.insurance.hcis.service.HospitalServiceImpl;
import com.insurance.hcis.service.PolicyServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class HospitalControllerTest {

	@Mock
	HospitalServiceImpl hospitalService;

	@InjectMocks
	HospitalController hospitalController;
	
	List<HospitalResponse> hospitals = new ArrayList<>();
	HospitalResponse hospital1 = new HospitalResponse();
	HospitalResponse hospital2 = new HospitalResponse();

	@Before
	public void setup() {
		log.info("Enter HospitalControllerTest:setup()");
		hospital1.setHospitalId(1);
		hospital1.setHospitalName("Appolo");
		hospital1.setHospitalId(2);
		hospital1.setHospitalName("kamineni");
		hospitals.add(hospital1);
		hospitals.add(hospital2);
	}

	@Test
	public void testgetHospitals() throws InvalidPolicyException {

		log.info("Enter HospitalControllerTest:testgetHospitals()");
		Mockito.when(hospitalService.getAllHospitals()).thenReturn(Optional.of(hospitals));
		ResponseEntity<HospitalResponseDto> RHospitalResponse = hospitalController.getHospitals();
		assertNotNull(RHospitalResponse);
	}
	
	@Test
	public void testgetHospitalsNegative() throws InvalidPolicyException {

		log.info("Enter HospitalControllerTest:testgetHospitalsNegative()");
		Mockito.when(hospitalService.getAllHospitals()).thenReturn(Optional.ofNullable(null));
		ResponseEntity<HospitalResponseDto> RHospitalResponse = hospitalController.getHospitals();
		assertNotNull(RHospitalResponse);
	}


}