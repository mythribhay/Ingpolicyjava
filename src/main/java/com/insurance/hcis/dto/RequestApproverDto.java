/**
 * 
 */
package com.insurance.hcis.dto;

import java.io.Serializable;

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
public class RequestApproverDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
}
