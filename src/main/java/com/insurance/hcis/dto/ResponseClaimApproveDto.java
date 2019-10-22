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
public class ResponseClaimApproveDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;
	private Integer statusCode;
	private String approvedLevelStatus;

}
