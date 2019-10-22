package com.insurance.hcis.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Description- This is an entity class for policyClaim.
 * 
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PolicyClaim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer claimId;
	private Integer policyId;
	private String diagnosis;
	private String ailment;

	private LocalDate admissionDate;
	private LocalDate dischargeDate;
	private LocalDate claimDate;
	private String status;
	private String hospitalName;
	private String approver1Comment;
	private String approver2Comment;
	private Double requestedClaimAmount;
	private Integer approverId;

}
