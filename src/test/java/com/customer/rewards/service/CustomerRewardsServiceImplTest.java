package com.customer.rewards.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.customer.rewards.model.CustomerRewardsResponse;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerRewardsServiceImplTest {

	private MockMvc mockMvc;
	@Mock
	private CustomerRewardsResponse customerRewards;
	
	@InjectMocks
	CustomerRewardsService customerRewardsService;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerRewardsService).build();

	}
	
	@DisplayName("Test SpringBoot @Calculate")
	@Test
	public void testcalculate(Long customerId) throws Exception {
		
		when(customerRewardsService.calculateRewardsforaCustomer(customerId)).thenReturn(customerRewards);

		CustomerRewardsResponse response = customerRewardsService.calculateRewardsforaCustomer(customerId);
		
		assertNotNull(response);
		
		verify(customerRewardsService).calculateRewardsforaCustomer(customerId);
		
		
	}
	
	@DisplayName("Test SpringBoot @CalculateMonthlyRewardsIfNoResults")
	@Test
	public void testcalculateIfNoResults(Long customerId)  throws Exception {
		
		when(customerRewardsService.calculateRewardsforaCustomer(customerId)).thenReturn(null);

		CustomerRewardsResponse response = customerRewardsService.calculateRewardsforaCustomer(customerId);
		
		assertNull(response);
		
		verify(customerRewardsService).calculateRewardsforaCustomer(customerId);
		
		
	}
}
