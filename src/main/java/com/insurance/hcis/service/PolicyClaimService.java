package com.insurance.hcis.service;

import com.insurance.hcis.dto.ClaimRequestDto;
import com.insurance.hcis.dto.ClaimResponseDto;

public interface PolicyClaimService {

	ClaimResponseDto claimPolicy(ClaimRequestDto claimRequestDto);

}
