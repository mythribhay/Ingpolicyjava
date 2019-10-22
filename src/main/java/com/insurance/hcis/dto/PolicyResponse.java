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

/**
 * Gets the status code.
 *
 * @return the status code
 */
@Getter

/**
 * Sets the ailments.
 *
 * @param ailments the new ailments
 */

/**
 * Sets the status code.
 *
 * @param statusCode the new status code
 */
@Setter

/**
 * Instantiates a new policy response.
 */

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
 * @param message the message
 * @param statusCode the status code
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
	
	/** The message. */
	private String message;
	
	/** The status code. */
	private int statusCode;
}
