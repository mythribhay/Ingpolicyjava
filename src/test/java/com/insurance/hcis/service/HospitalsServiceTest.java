package com.insurance.hcis.service;

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
import com.insurance.hcis.dto.HospitalResponse;
import com.insurance.hcis.entity.Hospital;
import com.insurance.hcis.repository.HospitalRepository;

@RunWith(MockitoJUnitRunner.class)
public class HospitalsServiceTest {

	@Mock
	HospitalRepository hospitalRepository;

	@InjectMocks
	HospitalServiceImpl hospitalService;
	List<Hospital> hospitals = new ArrayList<>();
	Hospital hospital1 = new Hospital();
	Hospital hospital2 = new Hospital();

	@Before
	public void setup() {

		hospital1.setHospitalId(1);
		hospital1.setHospitalName("Appolo");
		hospital1.setHospitalId(2);
		hospital1.setHospitalName("kamineni");
		hospitals.add(hospital1);
		hospitals.add(hospital2);
	}

	@Test
	public void testFetchBooks() {
		Mockito.when(hospitalRepository.findAll()).thenReturn(hospitals);
		Optional<List<HospitalResponse>> hospitalO = hospitalService.getAllHospitals();
		assertNotNull(hospitalO);

	}

}
