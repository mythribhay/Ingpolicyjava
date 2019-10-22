/**
 * 
 */
package com.insurance.hics.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.insurance.hcis.controller.ApproveController;
import com.insurance.hcis.dto.RequestClaimApproveDto;
import com.insurance.hcis.dto.ResponseClaimApproveDto;
import com.insurance.hcis.dto.ResponsePolicyClaim;
import com.insurance.hcis.dto.ResponsePolicyClaimDto;
import com.insurance.hcis.service.ApproverServiceImpl;

/**
 * @author SubhaMaheswaran
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ApproveControllerTest {

	@Mock
	ApproverServiceImpl approverServiceImpl;

	@InjectMocks
	ApproveController approveController;

	MockMvc mockMvc;

	RequestClaimApproveDto requestClaimApproveDto;

	List<ResponsePolicyClaim> list;
	ResponsePolicyClaim responsePolicyClaim;
	ResponseClaimApproveDto responseClaimApproveDto;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(approveController).build();

		requestClaimApproveDto = new RequestClaimApproveDto();
		requestClaimApproveDto.setApproverId(1001);
		requestClaimApproveDto.setClaimId(1);
		requestClaimApproveDto.setComments("test");
		requestClaimApproveDto.setLevelOneStatus("Approved");
		requestClaimApproveDto.setLevelTwoStatus("complete");

		responsePolicyClaim = new ResponsePolicyClaim();
		responsePolicyClaim.setAilment("Cavities");
		responsePolicyClaim.setClaimId(1);
		list = new ArrayList<>();
		list.add(responsePolicyClaim);

		responseClaimApproveDto = new ResponseClaimApproveDto();
		responseClaimApproveDto.setMessage("success");
		responseClaimApproveDto.setStatusCode(200);
	}

	@Test
	public void testGetClaims() throws Exception {
		Mockito.when(approverServiceImpl.getClaims(1, "pending L1")).thenReturn(Optional.of(list));
		ResponseEntity<ResponsePolicyClaimDto> responseClaimApproveDto = approveController.getClaims(1, "pending L1");
		Assert.assertNotNull(responseClaimApproveDto);
	}

	
}
