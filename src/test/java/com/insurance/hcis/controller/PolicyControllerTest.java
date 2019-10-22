package com.insurance.hcis.controller;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.insurance.hcis.dto.PolicyResponse;
import com.insurance.hcis.exception.InvalidPolicyException;
import com.insurance.hcis.service.PolicyServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PolicyControllerTest {

	@Mock
	PolicyServiceImpl policyService;

	@InjectMocks
	PolicyController policyController;

	@Test
	public void testVerifyAndGetPolicy() throws InvalidPolicyException {

		PolicyResponse policyResponse = new PolicyResponse();
		policyResponse.setPolicyId(1);
		policyResponse.setStatusCode(HttpStatus.OK.value());
		Mockito.when(policyService.verifyAndgetPolicy(1)).thenReturn(policyResponse);
		ResponseEntity<PolicyResponse> RPolicyResponse = policyController.verifyAndget(1);
		assertNotNull(RPolicyResponse);
	}

}