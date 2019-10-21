package com.insurance.hcis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Description- This is an entity class for approver.
 * 
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Approver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appoverId;
	private String approverName;
	private String email;
	private String password;
	private String role;
}
