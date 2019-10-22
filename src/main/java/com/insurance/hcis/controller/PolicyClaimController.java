package com.insurance.hcis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.hcis.dto.ClaimRequestDto;
import com.insurance.hcis.dto.ClaimResponseDto;
import com.insurance.hcis.service.PolicyClaimService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Manisha Yadav
 * @apiNote This controller is used to claim for the policy.
 */

@RestController
@RequestMapping("/books")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@Slf4j
public class PolicyClaimController {

	@Autowired
	PolicyClaimService policyClaimService;

	/*
	 * @Param- claimRequestDto
	 * 
	 * @Response -ResponseEntity of ClaimResponseDto
	 * 
	 * @Description -This method is used to save the book details which is donated
	 * by the specific user.
	 */
	@PostMapping("/claim")
	public ResponseEntity<ClaimResponseDto> policyClaim(@RequestBody ClaimRequestDto claimRequestDto) {
		log.info(":: Enter into PolicyClaimController--------::policyClaim()");
		ClaimResponseDto response = policyClaimService.claimPolicy(claimRequestDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
