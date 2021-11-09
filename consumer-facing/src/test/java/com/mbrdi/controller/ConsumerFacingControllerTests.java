package com.mbrdi.controller;

import static org.mockito.Mockito.*;
import static org.mockito.AdditionalMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbrdi.controller.ConsumerFacingController;
import com.mbrdi.model.CustomerDTO;
import com.mbrdi.model.StatusMessage;
import com.mbrdi.service.ConsumerFacingService;
import com.mbrdi.validations.CustomerValidations;


@WebMvcTest(ConsumerFacingController.class)
public class ConsumerFacingControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ConsumerFacingService consumerFacingService;

	@MockBean
	private CustomerValidations customerValidations;

	@Test
	public void testStoreCustomer() throws Exception{
		ObjectMapper objMapper = new ObjectMapper();
		CustomerDTO customer = new CustomerDTO(1, "suyash", "10-05-1997", 24, "1500000.25");
		String jsonStr = objMapper.writeValueAsString(customer);
		
		// mocking service class method
		when(consumerFacingService.publishToQueue(Mockito.any(CustomerDTO.class), eq(false), anyBoolean())).thenReturn(true);
		
		// mocking validations
		when(customerValidations.validateFileType(or(eq("csv"), eq("xml")))).thenReturn(new StatusMessage(true, ""));
		when(customerValidations.validateRequestBody(Mockito.any(CustomerDTO.class))).thenReturn(new StatusMessage(true, ""));		

		ResultActions result = mockMvc.perform(post("/store?fileType=xml").content(jsonStr)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk());
	}
	
	@Test
	public void testGetAllCustomers() throws Exception{
		CustomerDTO customer1 = new CustomerDTO(1, "suyash", "10-05-1997", 24, "1500000.25");
		CustomerDTO customer2 = new CustomerDTO(2, "john", "21-11-1997", 24, "8500700");
		
		List<CustomerDTO> customers = new ArrayList<>();
		customers.add(customer1); customers.add(customer2);	
		
		// mocking validations
		when(customerValidations.validateFileType(or(eq("csv"), eq("xml")))).thenReturn(new StatusMessage(true, ""));
		
		// mocking service class method
		when(consumerFacingService.getCustomers(or(eq("csv"), eq("xml")))).thenReturn(customers);
		
		ResultActions result = mockMvc.perform(get("/read?fileType=csv").contentType(MediaType.APPLICATION_JSON));		
		result.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)));
	}
	
	@Test
	public void testUpdateCustomer() throws Exception {
		
		ObjectMapper objMapper = new ObjectMapper();
		CustomerDTO customer = new CustomerDTO(1, "suyash ghosh", "10-05-1997", 24, "1500000.25");
		String jsonStr = objMapper.writeValueAsString(customer);
		
		// mocking service class method
		when(consumerFacingService.publishToQueue(Mockito.any(CustomerDTO.class), eq(true), anyBoolean())).thenReturn(true);
		
		// mocking validations
		when(customerValidations.validateFileType(or(eq("csv"), eq("xml")))).thenReturn(new StatusMessage(true, ""));
		when(customerValidations.validateRequestBody(Mockito.any(CustomerDTO.class))).thenReturn(new StatusMessage(true, ""));		

		ResultActions result = mockMvc.perform(put("/update?fileType=xml").content(jsonStr)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk());
	}

}
