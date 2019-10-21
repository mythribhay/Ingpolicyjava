package com.insurance.hcis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.insurance.hcis.dto.PolicyResponse;
import com.insurance.hcis.exception.InvalidPolicyException;
import com.insurance.hcis.service.PolicyService;
import com.insurance.hcis.util.ApplicationConstants;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class PolicyController.
 * @author sharath vemperala
 */
@RestController
@RequestMapping("/")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })

/** The Constant log. */
@Slf4j
public class PolicyController {
	
	/** The policy service. */
	@Autowired
	PolicyService policyService;
	
	/**
	 * Verify and get the policy if it is valid.
	 *
	 * @param policyId the policy id
	 * @return the response entity
	 * @throws InvalidPolicyException the invalid policy exception
	 */
	@GetMapping("/policies/{policyId}")
	public ResponseEntity<PolicyResponse> verifyAndget(@PathVariable Integer policyId) throws InvalidPolicyException{
		log.info(":: Enter into PolicyController--------::verifyAndget()");
		PolicyResponse policyResponse = policyService.verifyAndgetPolicy(policyId);
		policyResponse.setMessage(ApplicationConstants.SUCCESS);
		policyResponse.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(policyResponse, HttpStatus.OK);
		
	}

}
