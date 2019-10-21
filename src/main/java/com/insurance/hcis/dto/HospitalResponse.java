package com.insurance.hcis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Gets the hospital Response.
 *
 * @return the hospital name
 */
@Getter

/**
 * Sets the hospital name.
 *
 * @param hospitalName the new hospital name
 */
@Setter

/**
 * Instantiates a new hospital response.
 */
@NoArgsConstructor

/**
 * Instantiates a new hospital response.
 *
 * @param hospitalId the hospital id
 * @param hospitalName the hospital name
 */
@AllArgsConstructor
public class HospitalResponse {

	/** The hospital id. */
	private Integer hospitalId;
	
	/** The hospital name. */
	private String hospitalName;

}
