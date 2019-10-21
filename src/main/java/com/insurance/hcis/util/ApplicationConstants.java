  
package com.insurance.hcis.util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
/**
 * 
 *Description- Purpose of this class is to maintain application constants values.
 *
 */
@Component
public class ApplicationConstants {
	
	public static final Integer FIRST_APPROVER_ID = 1;
	public static final Integer SECOND_APPROVER_ID = 1;
	public static final Integer SUCESS_STATUS_CODE = HttpStatus.CREATED.value();
	public static final String CLAIM_POLICY_SUCESS_MESSAGE = "Claim Submitted";
	public static final String SUCCESS = "sucess";
	public static final String FAILURE = "Failure";
	public static final String VERIFICATION_FAILED = "Policy is expired";
	public static final String INVALID_POLICY = "Invalid policy";
}