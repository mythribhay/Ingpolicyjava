/**
 * 
 */
package com.insurance.hcis.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.hcis.dto.RequestApproverDto;
import com.insurance.hcis.dto.ResponseApproverDto;
import com.insurance.hcis.entity.Approver;
import com.insurance.hcis.exception.CommonException;
import com.insurance.hcis.repository.ApproverRepository;
import com.insurance.hcis.util.ApplicationConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SubhaMaheswaran
 *
 *
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

	@Autowired
	ApproverRepository approverRepository;

	/**
	 * @Description This method is used for approver login
	 * @param RequestApproverDto
	 * @return ResponseApproverDto
	 * @exception INVALID_CREDENTIALS
	 */
	public Optional<ResponseApproverDto> login(RequestApproverDto requestApproverDto) throws CommonException {
		log.info(":: Enter into LoginServiceImpl--------::login()");
		Optional<Approver> approverDetails = approverRepository.findByEmailAndPassword(requestApproverDto.getEmail(),
				requestApproverDto.getPassword());
		/**
		 * @Description checking the data is present or not
		 * 
		 */
		if (!(approverDetails.isPresent())) {
			throw new CommonException(ApplicationConstants.INVALID_CREDENTIALS);
		}

		Optional<ResponseApproverDto> optionalResponseApproverDto;
		ResponseApproverDto responseApproverDto = new ResponseApproverDto();

		BeanUtils.copyProperties(approverDetails.get(), responseApproverDto);
		optionalResponseApproverDto = Optional.of(responseApproverDto);
		return optionalResponseApproverDto;
	}

}
