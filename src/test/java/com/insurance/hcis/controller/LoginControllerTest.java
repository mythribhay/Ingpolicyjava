/**
 * 
 */
package com.insurance.hcis.controller;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.insurance.hcis.dto.RequestApproverDto;
import com.insurance.hcis.dto.ResponseApproverDto;
import com.insurance.hcis.exception.CommonException;
import com.insurance.hcis.service.LoginServiceImpl;

/**
 * @author SubhaMaheswaran
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@Mock
	LoginServiceImpl loginServiceImpl;

	@InjectMocks
	LoginController loginController;

	MockMvc mockMvc;
	RequestApproverDto requestApproverDto;

	ResponseApproverDto responseApproverDto;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
		requestApproverDto = new RequestApproverDto();
		responseApproverDto = new ResponseApproverDto();
		responseApproverDto.setAppoverId(1001);
		responseApproverDto.setRole("Approver1");
		requestApproverDto.setEmail("tushar@insurance.com");
		requestApproverDto.setPassword("app1pwd");
	}

	@Test
	public void testLogin() throws Exception {
		Mockito.when(loginServiceImpl.login(Mockito.any())).thenReturn(Optional.of(responseApproverDto));
		ResponseEntity<Optional<ResponseApproverDto>> responseClaimApproveDto = loginController
				.login(requestApproverDto);
		Assert.assertNotNull(responseClaimApproveDto);
	}

	@Test(expected = CommonException.class)
	public void testLoginNegative() throws Exception {
		Mockito.when(loginServiceImpl.login(Mockito.any())).thenReturn(Optional.ofNullable(null));
		ResponseEntity<Optional<ResponseApproverDto>> responseClaimApproveDto = loginController
				.login(requestApproverDto);
		Assert.assertNotNull(responseClaimApproveDto);
	}

}
