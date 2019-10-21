/**
 * 
 */
package com.insurance.hcis.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author User1
 *
 */
@Getter
@Setter
public class CommonException extends Exception {

	private static final long serialVersionUID = 1L;

	public CommonException(String message) {
		super(message);
	}
}
