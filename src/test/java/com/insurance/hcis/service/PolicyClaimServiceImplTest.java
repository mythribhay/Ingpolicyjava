package com.insurance.hcis.service;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.insurance.hcis.dto.ClaimRequestDto;
import com.insurance.hcis.dto.ClaimResponseDto;
import com.insurance.hcis.repository.PolicyClaimRepository;

@RunWith(MockitoJUnitRunner.class)
public class PolicyClaimServiceImplTest {

	@Mock
	PolicyClaimRepository policyClaimRepository;
	@InjectMocks
	PolicyClaimServiceImpl policyClaimServiceImpl;
	
	@Test
	public void testClaimPolicy() {
		ClaimResponseDto claimResponseDto = new ClaimResponseDto();
		claimResponseDto.setClaimId(1);
		claimResponseDto.setMessage("sucess");
		claimResponseDto.setStatusCode(200);
		
		ClaimRequestDto claimRequestDto = new ClaimRequestDto();
		claimRequestDto.setAdmissionDate(LocalDate.now());
		claimRequestDto.setAilment("cavities");
		claimRequestDto.setApprover1Comment("Approve1");
		claimRequestDto.setApprover2Comment("Approve2");
		claimRequestDto.setClaimDate(LocalDate.now());
		claimRequestDto.setDiagnosis("dental");
		claimRequestDto.setHospitalName("apolo");
		claimRequestDto.setPolicyId(1);
		claimRequestDto.setRequestedClaimAmount(8756.0);
		claimRequestDto.setStatus("pending");
		claimRequestDto.setDischargeDate(LocalDate.now());
		
		Optional<ClaimResponseDto> actual = policyClaimServiceImpl.claimPolicy(claimRequestDto);
		assertNotNull(actual);
	}

}
