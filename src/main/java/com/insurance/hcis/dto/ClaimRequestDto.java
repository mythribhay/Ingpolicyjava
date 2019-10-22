package com.insurance.hcis.dto;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClaimRequestDto {

	private Integer policyId;
	private String diagnosis;
	private String ailment;
	private String hospitalName;
	private LocalDate admissionDate;
	private LocalDate dischargeDate;
	private LocalDate claimDate;
	private String status;
	private String approver1Comment;
	private String approver2Comment;
	private Double requestedClaimAmount;

}
