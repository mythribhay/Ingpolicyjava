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

// TODO: Auto-generated Javadoc
/**
 *This is an entity class for Policy.
 *@author sharath vemperala
 * 
 */

@Entity

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
 * Instantiates a new policy.
 */
@NoArgsConstructor

/**
 * Instantiates a new policy.
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
public class Policy {

	/** The policy id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
