/**
 * 
 */
package com.insurance.hcis.service;

import java.util.List;
import java.util.Optional;

import com.insurance.hcis.dto.RequestClaimApproveDto;
import com.insurance.hcis.dto.ResponseClaimApproveDto;
import com.insurance.hcis.dto.ResponsePolicyClaim;
import com.insurance.hcis.exception.CommonException;

/**
 * @author SubhaMaheswaran
 *
 */
public interface ApproverService {

	/**
	 * @param approverId
	 * @param status
	 * @return List<ResponsePolicyClaim>
	 * @throws CommonException
	 */
	Optional<List<ResponsePolicyClaim>> getClaims(Integer approverId, String status) throws CommonException;

	/**
	 * @param requestClaimApproveDto
	 * @return ResponseClaimApproveDto
	 * @throws CommonException
	 */
	ResponseClaimApproveDto approveClaim(RequestClaimApproveDto requestClaimApproveDto) throws CommonException;

}
