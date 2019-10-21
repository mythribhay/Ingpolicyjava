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
}
