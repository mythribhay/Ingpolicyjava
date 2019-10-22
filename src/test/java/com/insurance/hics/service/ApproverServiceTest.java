/**
 * 
 */
package com.insurance.hics.service;

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

import com.insurance.hcis.dto.RequestClaimApproveDto;
import com.insurance.hcis.dto.ResponseClaimApproveDto;
import com.insurance.hcis.dto.ResponsePolicyClaim;
import com.insurance.hcis.entity.Policy;
import com.insurance.hcis.entity.PolicyClaim;
import com.insurance.hcis.exception.CommonException;
import com.insurance.hcis.repository.ApproverRepository;
import com.insurance.hcis.repository.PolicyClaimRepository;
import com.insurance.hcis.repository.PolicyRepository;
import com.insurance.hcis.service.ApproverServiceImpl;

/**
 * @author SubhaMaheswaran
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ApproverServiceTest {

	@Mock
	ApproverRepository approverRepository;

	@Mock
	PolicyClaimRepository policyClaimRepository;

	@Mock
	PolicyRepository policyRepository;

	@InjectMocks
	ApproverServiceImpl approverServiceImpl;

	Policy responsePolicy;

	Optional<List<PolicyClaim>> listPolicyClaim;

	List<PolicyClaim> listOfPolicyClaim;

	PolicyClaim policyClaim;

	RequestClaimApproveDto requestClaimApproveDto;
	RequestClaimApproveDto requestClaimApproveDto1;
	RequestClaimApproveDto requestClaimApproveDto2;
	RequestClaimApproveDto requestClaimApproveDto3;
	RequestClaimApproveDto requestClaimApproveDto4;

	@Before
	public void setup() {
		policyClaim = new PolicyClaim();
		policyClaim.setDiagnosis("Dental");
		policyClaim.setPolicyId(1);
		policyClaim.setAilment("Cavities");
		listOfPolicyClaim = new ArrayList<>();
		listOfPolicyClaim.add(policyClaim);
		listPolicyClaim = Optional.of(listOfPolicyClaim);

		responsePolicy = new Policy();
		responsePolicy.setPolicyId(1);
		responsePolicy.setDiagnosis("Dental");
		responsePolicy.setAilment("Cavities");

		requestClaimApproveDto = new RequestClaimApproveDto();
		requestClaimApproveDto.setClaimId(1);
		requestClaimApproveDto.setApproverId(1);
		requestClaimApproveDto.setLevelOneStatus("Approved");
		requestClaimApproveDto.setLevelTwoStatus("complete");

		requestClaimApproveDto1 = new RequestClaimApproveDto();
		requestClaimApproveDto1.setApproverId(3);
		requestClaimApproveDto1.setClaimId(4);

		requestClaimApproveDto2 = new RequestClaimApproveDto();
		requestClaimApproveDto2.setApproverId(1);
		requestClaimApproveDto2.setLevelOneStatus("done");

		requestClaimApproveDto3 = new RequestClaimApproveDto();
		requestClaimApproveDto2.setApproverId(1);
		requestClaimApproveDto3.setLevelTwoStatus("okay");

		requestClaimApproveDto4 = new RequestClaimApproveDto();
		requestClaimApproveDto4.setApproverId(1);
		requestClaimApproveDto4.setClaimId(1);
		requestClaimApproveDto4.setComments("approved");
		requestClaimApproveDto4.setLevelOneStatus("Approved");
		requestClaimApproveDto4.setLevelTwoStatus("complete");

	}

	@Test
	public void testGetClaims() throws CommonException {
		Mockito.when(policyClaimRepository.findByApproverIdAndStatus(Mockito.anyInt(), Mockito.anyString()))
				.thenReturn(listPolicyClaim);
		Mockito.when(policyRepository.findByDiagnosisAndAilmentAndPolicyId(Mockito.anyString(), Mockito.anyString(),
				Mockito.anyInt())).thenReturn(responsePolicy);
		Optional<List<ResponsePolicyClaim>> response = approverServiceImpl.getClaims(1, "PendingL1");
		Assert.assertEquals(listPolicyClaim.get().size(), response.get().size());
	}

	@Test(expected = CommonException.class)
	public void testApproveClaimForNUll() throws CommonException {
		ResponseClaimApproveDto response = approverServiceImpl.approveClaim(null);
		Assert.assertNull(response);
	}

	@Test(expected = CommonException.class)
	public void testtestApproveClaimForPolicy() throws CommonException {
		Mockito.when(policyClaimRepository.findByApproverIdAndClaimId(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(null);
		ResponseClaimApproveDto response = approverServiceImpl.approveClaim(requestClaimApproveDto);
		Assert.assertNull(response);
	}

	@Test(expected = CommonException.class)
	public void testtestApproveClaimForApproverId() throws CommonException {
		Mockito.when(policyClaimRepository.findByApproverIdAndClaimId(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(policyClaim);
		ResponseClaimApproveDto response = approverServiceImpl.approveClaim(requestClaimApproveDto1);
		Assert.assertNull(response);
	}

	@Test(expected = CommonException.class)
	public void testApproveClaimForLevelOneStatus() throws CommonException {
		ResponseClaimApproveDto response = approverServiceImpl.approveClaim(requestClaimApproveDto2);
		Assert.assertNull(response);
	}

	@Test(expected = CommonException.class)
	public void testApproveClaimForLevelTwoStatus() throws CommonException {
		ResponseClaimApproveDto response = approverServiceImpl.approveClaim(requestClaimApproveDto3);
		Assert.assertNull(response);
	}

}
