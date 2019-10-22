package com.insurance.hcis.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.hcis.dto.RequestApproverDto;
import com.insurance.hcis.dto.ResponseApproverDto;
import com.insurance.hcis.exception.CommonException;
import com.insurance.hcis.service.LoginService;
import com.insurance.hcis.util.ApplicationConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SubhaMaheswaran
 * @Description This class is used to do the login operation
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/approver")
@Slf4j
public class LoginController {

	@Autowired
	LoginService loginService;

	/**
	 * @Description This method is used for approver login
	 * @param RequestApproverDto
	 * @return ResponseApproverDto
	 * @exception INVALID_CREDENTIALS
	 */
	@PostMapping("/login")
	public ResponseEntity<Optional<ResponseApproverDto>> login(@RequestBody RequestApproverDto requestApproverDto)
			throws CommonException {
		log.info(":: Enter into LoginController--------::login()");
		Optional<ResponseApproverDto> responseApproverDto = loginService.login(requestApproverDto);
		if (!(responseApproverDto.isPresent())) {
			throw new CommonException(ApplicationConstants.INVALID_CREDENTIALS);
		}
		responseApproverDto.get().setMessage("login successfull");
		responseApproverDto.get().setStatusCode(200);
		return new ResponseEntity<>(responseApproverDto, HttpStatus.OK);
	}
}
