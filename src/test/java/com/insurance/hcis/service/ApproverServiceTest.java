/**
 * 
 */
package com.insurance.hcis.service;

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
	RequestClaimApproveDto requestClaimApproveDto5;
	RequestClaimApproveDto requestClaimApproveDto6;
	RequestClaimApproveDto requestClaimApproveDto7;

	ResponseClaimApproveDto response;

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
		requestClaimApproveDto3.setApproverId(1);
		requestClaimApproveDto3.setLevelTwoStatus("okay");

		requestClaimApproveDto4 = new RequestClaimApproveDto();
		requestClaimApproveDto4.setApproverId(1);
		requestClaimApproveDto4.setClaimId(1);
		requestClaimApproveDto4.setComments("approved");
		requestClaimApproveDto4.setLevelOneStatus("Approved");
		requestClaimApproveDto4.setLevelTwoStatus("complete");

		requestClaimApproveDto5 = new RequestClaimApproveDto();
		requestClaimApproveDto5.setApproverId(1001);
		requestClaimApproveDto5.setClaimId(1);
		requestClaimApproveDto5.setLevelOneStatus("Approved");
		requestClaimApproveDto5.setLevelTwoStatus("complete");

		requestClaimApproveDto6 = new RequestClaimApproveDto();
		requestClaimApproveDto6.setApproverId(1001);
		requestClaimApproveDto6.setClaimId(1);
		requestClaimApproveDto6.setLevelOneStatus("Approved");
		requestClaimApproveDto6.setLevelTwoStatus("not-complete");

		requestClaimApproveDto7 = new RequestClaimApproveDto();
		requestClaimApproveDto7.setApproverId(2001);
		requestClaimApproveDto7.setClaimId(1);
		requestClaimApproveDto7.setLevelOneStatus("Approved");
		requestClaimApproveDto7.setLevelTwoStatus("complete");

	}

	@Test
	public void testGetClaims() throws CommonException {
		Mockito.when(policyClaimRepository.findByApproverIdAndStatus(Mockito.anyInt(), Mockito.anyString()))
				.thenReturn(listPolicyClaim);

		Mockito.when(policyRepository.findByDiagnosisAndAilmentAndPolicyId(Mockito.anyString(), Mockito.anyString(),
				Mockito.anyInt())).thenReturn(responsePolicy);
		Optional<List<ResponsePolicyClaim>> responseClaim = approverServiceImpl.getClaims(1, "PendingL1");
		Assert.assertEquals(listPolicyClaim.get().size(), responseClaim.get().size());
	}

	@Test(expected = CommonException.class)
	public void testGetClaimsNegative() throws CommonException {
		Mockito.when(policyClaimRepository.findByApproverIdAndStatus(Mockito.anyInt(), Mockito.anyString()))
				.thenReturn(Optional.ofNullable(null));
		Optional<List<ResponsePolicyClaim>> responseClaim = approverServiceImpl.getClaims(1, "PendingL1");
		Assert.assertEquals(listPolicyClaim.get().size(), responseClaim.get().size());
	}

	@Test(expected = CommonException.class)
	public void testApproveClaimForNUll() throws CommonException {
		response = approverServiceImpl.approveClaim(null);
		Assert.assertNull(response);
	}

	@Test(expected = CommonException.class)
	public void testtestApproveClaimForApproverId() throws CommonException {
		response = approverServiceImpl.approveClaim(requestClaimApproveDto1);
		Assert.assertNull(response);
	}

	@Test(expected = CommonException.class)
	public void testApproveClaimForLevelOneStatus() throws CommonException {
		response = approverServiceImpl.approveClaim(requestClaimApproveDto2);
		Assert.assertNull(response);
	}

	@Test(expected = CommonException.class)
	public void testApproveClaimForLevelTwoStatus() throws CommonException {
		response = approverServiceImpl.approveClaim(requestClaimApproveDto3);
		Assert.assertNotNull(response);
	}

	@Test(expected = CommonException.class)
	public void testtestApproveClaimForPolicy() throws CommonException {

		response = approverServiceImpl.approveClaim(requestClaimApproveDto);
		Assert.assertNull(response);
	}

	@Test
	public void testtestApproveClaimForLevelOne() throws CommonException {
		Mockito.when(policyClaimRepository.findByApproverIdAndClaimId(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(Optional.of(policyClaim));
		Mockito.when(policyClaimRepository.save(Mockito.any())).thenReturn(null);
		response = approverServiceImpl.approveClaim(requestClaimApproveDto5);
		Assert.assertNotNull(response);
	}

	@Test
	public void testtestApproveClaimForLevelOneToLevelTwo() throws CommonException {
		Mockito.when(policyClaimRepository.findByApproverIdAndClaimId(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(Optional.of(policyClaim));
		Mockito.when(policyClaimRepository.save(Mockito.any())).thenReturn(null);
		response = approverServiceImpl.approveClaim(requestClaimApproveDto6);
		Assert.assertNotNull(response);
	}

	@Test
	public void testtestApproveClaimForLevelTwo() throws CommonException {
		Mockito.when(policyClaimRepository.findByApproverIdAndClaimId(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(Optional.of(policyClaim));
		Mockito.when(policyClaimRepository.save(Mockito.any())).thenReturn(null);
		response = approverServiceImpl.approveClaim(requestClaimApproveDto7);
		Assert.assertNotNull(response);
	}
}
