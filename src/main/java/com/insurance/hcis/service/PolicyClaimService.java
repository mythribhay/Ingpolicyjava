package com.insurance.hcis.service;

import java.util.Optional;

import com.insurance.hcis.dto.ClaimRequestDto;
import com.insurance.hcis.dto.ClaimResponseDto;

public interface PolicyClaimService {

	Optional<ClaimResponseDto> claimPolicy(ClaimRequestDto claimRequestDto);

}
