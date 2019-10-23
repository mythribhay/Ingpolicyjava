/**
 * 
 */
package com.insurance.hcis.dto;

import java.io.File;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author User1
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class ResponsePolicyClaim {
	private Double claimAmount;
	private Integer claimId;
	private Integer policyId;
	private String diagnosis;
	private String ailment;
	private LocalDate admissionDate;
	private LocalDate dischargeDate;
	private File document;
	private LocalDate claimDate;
	private String status;
	private String comments;
	private String hospitalName;
	private Double requestedClaimAmount;
	private String approver1Comment;
	private String approver2Comment;
	
}
