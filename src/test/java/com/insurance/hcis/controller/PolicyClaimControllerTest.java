package com.insurance.hcis.controller;


import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.insurance.hcis.dto.ClaimRequestDto;
import com.insurance.hcis.dto.ClaimResponseDto;
import com.insurance.hcis.service.PolicyClaimService;

@RunWith(MockitoJUnitRunner.class)
public class PolicyClaimControllerTest {
	
	@Mock
	PolicyClaimService policyClaimService;
	@InjectMocks
	PolicyClaimController policyClaimController;
	
	@Test
	public void testPolicyClaim() {

			ClaimResponseDto claimResponseDto = new ClaimResponseDto();
			claimResponseDto.setClaimId(1);
			claimResponseDto.setMessage("sucess");
			claimResponseDto.setStatusCode(200);
			Mockito.when(policyClaimService.claimPolicy(Mockito.any())).thenReturn(claimResponseDto);

			ClaimRequestDto claimRequestDto = new ClaimRequestDto();
			claimRequestDto.setAdmissionDate(LocalDate.now());
			claimRequestDto.setAilment("hnhs");
			claimRequestDto.setApprover1Comment("Adada");
			claimRequestDto.setApprover2Comment("ibiut");
			claimRequestDto.setClaimDate(LocalDate.now());
			claimRequestDto.setDiagnosis("kjgg");
			claimRequestDto.setHospitalName("apolo");
			claimRequestDto.setPolicyId(1);
			claimRequestDto.setRequestedClaimAmount(8756.0);
			claimRequestDto.setStatus("ygduyf");
			claimRequestDto.setDischargeDate(LocalDate.now());
			
			ResponseEntity<ClaimResponseDto> actual = policyClaimController.policyClaim(claimRequestDto);
			assertNotNull(actual);
		}

}
