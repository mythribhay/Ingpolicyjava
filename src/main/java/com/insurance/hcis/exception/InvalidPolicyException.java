package com.insurance.hcis.exception;

/**
 * Description- This class is used to throw invalidPolicyException in case policyId is not found in our DB.
 */
public class InvalidPolicyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

public InvalidPolicyException(String message)
	{
		super(message);
	}
}
