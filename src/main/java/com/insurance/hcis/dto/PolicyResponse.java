package com.insurance.hcis.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Gets the ailments.
 *
 * @return the ailments
 */
@Getter

/**
 * Sets the ailments.
 *
 * @param ailments the new ailments
 */
@Setter

/**
 * Instantiates a new policy response.
 */
@NoArgsConstructor

/**
 * Instantiates a new policy response.
 *
 * @param policyId the policy id
 * @param startDate the start date
 * @param endDate the end date
 * @param claimAmount the claim amount
 * @param userName the user name
 * @param dob the dob
 * @param diagnosis the diagnosis
 * @param ailments the ailments
 */
@AllArgsConstructor
public class PolicyResponse {

/** The policy id. */
private Integer policyId;
	
	/** The start date. */
	private LocalDate startDate;
	
	/** The end date. */
	private LocalDate endDate;
	
	/** The claim amount. */
	private Double claimAmount;
	
	/** The user name. */
	private String userName;
	
	/** The dob. */
	private LocalDate dob;
	
	/** The diagnosis. */
	private String diagnosis;
	
	/** The ailments. */
	private String ailments;
}
