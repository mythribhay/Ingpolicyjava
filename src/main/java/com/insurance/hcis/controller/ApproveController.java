/**
 * 
 */
package com.insurance.hcis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.hcis.dto.RequestClaimApproveDto;
import com.insurance.hcis.dto.ResponseClaimApproveDto;
import com.insurance.hcis.dto.ResponsePolicyClaim;
import com.insurance.hcis.dto.ResponsePolicyClaimDto;
import com.insurance.hcis.exception.CommonException;
import com.insurance.hcis.service.ApproverService;
import com.insurance.hcis.util.ApplicationConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SubhaMaheswaran
 * @Description This class is used for to do the get claim and Approve
 *              operations
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/approver")
@Slf4j
public class ApproveController {

	@Autowired
	ApproverService approverService;

	/**
	 * @Description This method is used get list of claims
	 * @param approverId,status
	 * @return ResponsePolicyClaimDto
	 * @exception NO_CLAIMS_FOUND
	 */
	@GetMapping("/{approverId}/claims/")
	public ResponseEntity<ResponsePolicyClaimDto> getClaims(@PathVariable("approverId") Integer approverId,
			@RequestParam String status) throws CommonException {
		log.info(":: Enter into ApproveController--------::getClaims()");
		Optional<List<ResponsePolicyClaim>> listResponsePolicyClaim = approverService.getClaims(approverId, status);
		/**
		 * @Description Checking the response data is present or not
		 * @exception NO_CLAIMS_FOUND
		 */
		if (!(listResponsePolicyClaim.isPresent())) {
			throw new CommonException(ApplicationConstants.NO_CLAIMS_FOUND);

		}
		List<ResponsePolicyClaimDto> list = new ArrayList<>();
		ResponsePolicyClaimDto responsePolicyClaimDto = new ResponsePolicyClaimDto();
		responsePolicyClaimDto.setPolicyClaim(listResponsePolicyClaim.get());
		responsePolicyClaimDto.setMessage("Success");
		responsePolicyClaimDto.setStatuCode(200);
		list.add(responsePolicyClaimDto);
		return new ResponseEntity<>(responsePolicyClaimDto, HttpStatus.OK);
	}

	/**
	 * @Description This method is used approve the claim
	 * @param requestClaimApproveDto
	 * @return ResponseClaimApproveDto
	 * @exception CLAIM_APPROVED_FAILED
	 */
	@PostMapping("/claim/approve")
	public ResponseEntity<ResponseClaimApproveDto> approveClaim(
			@RequestBody RequestClaimApproveDto requestClaimApproveDto) throws CommonException {
		ResponseClaimApproveDto responseClaimApproveDto = approverService.approveClaim(requestClaimApproveDto);
		/**
		 * @Description Checking the response data is empty
		 * @exception CLAIM_APPROVED_FAILED
		 */
		if (responseClaimApproveDto.getApprovedLevelStatus().isEmpty()) {
			throw new CommonException(ApplicationConstants.CLAIM_APPROVED_FAILED);
		}
		responseClaimApproveDto.setMessage("claim approved successfully");
		responseClaimApproveDto.setStatusCode(200);
		return new ResponseEntity<>(responseClaimApproveDto, HttpStatus.OK);
	}
}
