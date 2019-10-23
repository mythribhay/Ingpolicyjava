package com.insurance.hcis.service;

import java.util.Optional;

import com.insurance.hcis.dto.ClaimRequestDto;
import com.insurance.hcis.dto.ClaimResponseDto;

/**
 * The Interface PolicyClaimService.
 * 
 * @author sharath vemperala
 */
public interface PolicyClaimService {

	/**
	 * Claim policy.
	 *
	 * @param claimRequestDto the claim request dto
	 * @return the claim response dto
	 */
	Optional<ClaimResponseDto> claimPolicy(ClaimRequestDto claimRequestDto);

}
