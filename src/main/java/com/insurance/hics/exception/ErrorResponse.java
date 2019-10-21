package com.insurance.hcis.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 *Description- This class is used to handle error msgs.
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	private String message;
	private int statusCode;

}
