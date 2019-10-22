package com.insurance.hcis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClaimResponseDto {

	private Integer claimId;
	private String message; 
	private Integer statusCode;
}
