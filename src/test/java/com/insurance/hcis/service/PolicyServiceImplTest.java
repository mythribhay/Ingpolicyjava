package com.insurance.hcis.service;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.insurance.hcis.dto.PolicyResponse;
import com.insurance.hcis.entity.Policy;
import com.insurance.hcis.exception.InvalidPolicyException;
import com.insurance.hcis.repository.PolicyRepository;

@RunWith(MockitoJUnitRunner.class)
public class PolicyServiceImplTest {

	@Mock
	PolicyRepository policyRepository;

	@InjectMocks
	PolicyServiceImpl policyService;

	@Before
	public void setup() {

	}

	@Test
	public void testVerifyAndGetPolicy() throws InvalidPolicyException {
		Policy policy = new Policy();
		policy.setEndDate(LocalDate.now().plusDays(1L));
		policy.setPolicyId(1);
		Mockito.when(policyRepository.findById(1)).thenReturn(Optional.of(policy));
		PolicyResponse policyResponse = policyService.verifyAndgetPolicy(1);
		assertNotNull(policyResponse);

	}

	@Test(expected = InvalidPolicyException.class)
	public void testVerifyAndGetPolicyNegativeInvalidPolicyId() throws InvalidPolicyException {
		Policy policy = new Policy();
		policy.setEndDate(LocalDate.now().plusDays(1L));
		policy.setPolicyId(1);
		PolicyResponse policyResponse = policyService.verifyAndgetPolicy(2);
		assertNotNull(policyResponse);

	}

	@Test(expected = InvalidPolicyException.class)
	public void testVerifyAndGetPolicyNegativeExpireDate() throws InvalidPolicyException {
		Policy policy = new Policy();
		policy.setEndDate(LocalDate.now().minusDays(1L));
		policy.setPolicyId(1);
		Mockito.when(policyRepository.findById(1)).thenReturn(Optional.of(policy));
		PolicyResponse policyResponse = policyService.verifyAndgetPolicy(1);
		assertNotNull(policyResponse);

	}

}
