/**
 * 
 */
package com.insurance.hcis.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author SubhaMaheswaran
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class ResponseApproverDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer appoverId;
	private String approverName;
	private String role;
	private String message;
	private Integer statusCode;
}
