/**
 * 
 */
package com.insurance.hcis.service;

import java.util.Optional;

import com.insurance.hcis.dto.RequestApproverDto;
import com.insurance.hcis.dto.ResponseApproverDto;
import com.insurance.hcis.exception.CommonException;

/**
 * @author User1
 *
 */
public interface LoginService {

	/**
	 * @param requestApproverDto
	 * @return
	 */
	Optional<ResponseApproverDto> login(RequestApproverDto requestApproverDto) throws CommonException;

}
