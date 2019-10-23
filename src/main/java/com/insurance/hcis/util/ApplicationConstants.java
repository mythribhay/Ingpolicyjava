
package com.insurance.hcis.util;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 
 * Description- Purpose of this class is to maintain application constants
 * values.
 *
 */
@Component
public class ApplicationConstants {

	private ApplicationConstants() {

	}

	public static final Integer FIRST_APPROVER_ID = 1001;
	public static final Integer SECOND_APPROVER_ID = 2001;
	public static final Integer SUCESS_STATUS_CODE = HttpStatus.CREATED.value();
	public static final String CLAIM_POLICY_SUCESS_MESSAGE = "Claim Submitted";
	public static final String SUCCESS = "sucess";
	public static final String FAILURE = "Failure";
	public static final String VERIFICATION_FAILED = "Policy is expired";
	public static final String INVALID_POLICY = "Invalid policy";
	public static final String INVALID_CREDENTIALS = "Invalid email or password";

	public static final String NO_CLAIMS_FOUND = "No claims found";
	public static final String INVALID_APPROVAL_DETAILS = "All details are mandatory";
	public static final String INVALID_APPROVER_ID = "Approver not found";
	public static final String INVALID_LEVEL_ONE_STATUS = "Invalid level one status";
	public static final String INVALID_LEVEL_TWO_STATUS = "Invalid level two status";
	public static final String CLAIM_APPROVED_FAILED = "Claim approve was failed";
	public static final String INVALID_STATUS_FOR_L2_APPROVAL = "Invalid status for approve";

}
