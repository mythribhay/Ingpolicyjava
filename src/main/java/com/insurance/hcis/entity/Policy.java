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
 * Description- This is an entity class for Policy.
 * 
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer policyId;
	private LocalDate startDate;
	private LocalDate endDate;
	private Double claimAmount;
	private String userName;
	private LocalDate dob;
	private String diagnosis;
	private String ailment;
}
