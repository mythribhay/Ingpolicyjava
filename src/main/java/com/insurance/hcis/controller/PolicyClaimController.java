package com.insurance.hcis.controller;

import java.util.Optional;

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
import com.insurance.hcis.exception.CommonException;
import com.insurance.hcis.service.PolicyClaimService;
import com.insurance.hcis.util.ApplicationConstants;

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
	 * @Description -This method is used to save the claim of policy taken by user while health insurance.
	 * @Param- claimRequestDto
	 * @Response- ResponseEntity of Optional<ClaimResponseDto>
	 * @Exception- CommonException
	 */
	@PostMapping("/claim")
	public ResponseEntity<Optional<ClaimResponseDto>> policyClaim(@RequestBody ClaimRequestDto claimRequestDto)
			throws CommonException {
		log.info(":: Enter into PolicyClaimController--------::policyClaim()");
		Optional<ClaimResponseDto> response = policyClaimService.claimPolicy(claimRequestDto);
		if (!(response.isPresent())) {
			throw new CommonException(ApplicationConstants.CLAIM_SUMBITTED_FAILED);
		}
		response.get().setMessage("Claim submitted");
		response.get().setStatusCode(200);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
