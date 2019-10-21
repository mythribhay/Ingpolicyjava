package com.insurance.hcis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.hcis.dto.HospitalResponse;
import com.insurance.hcis.dto.HospitalResponseDto;
import com.insurance.hcis.service.HospitalService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@Slf4j
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;
	
	@GetMapping("/hospitals")
	public ResponseEntity<HospitalResponseDto> getHospitals(){
		log.info(":: Enter into HospitalController--------::getHospitals()");
		Optional<List<HospitalResponse>> hospitalsO = hospitalService.getAllHospitals();
		HospitalResponseDto hospitalResponseDto = new HospitalResponseDto();
		if(!hospitalsO.isPresent()) {
			hospitalResponseDto.setMessage("Failure");
			hospitalResponseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<>(hospitalResponseDto, HttpStatus.OK);
		}
		hospitalResponseDto.setMessage("sucess");
		hospitalResponseDto.setStatusCode(HttpStatus.OK.value());
		hospitalResponseDto.setListOfHospitals(hospitalsO.get());
		return new ResponseEntity<>(hospitalResponseDto, HttpStatus.OK);
		
	}

}
