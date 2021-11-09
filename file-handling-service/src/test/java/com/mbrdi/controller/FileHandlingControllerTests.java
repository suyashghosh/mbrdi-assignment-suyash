package com.mbrdi.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.mbrdi.model.CustomerDTO;
import com.mbrdi.protobufs.CustomerProto;
import com.mbrdi.protobufs.CustomerTransferProto;
import com.mbrdi.service.FileHandlingService;

@WebMvcTest(FileHandlingController.class)
public class FileHandlingControllerTests {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	FileHandlingService fileHandlingService;
	
	@Test
	public void testGetCustomers() throws Exception {
		CustomerDTO customer1 = new CustomerDTO(1, "suyash", "10-05-1997", 24, "1500000.25");
		CustomerDTO customer2 = new CustomerDTO(2, "john", "21-11-1997", 24, "8500700");
		
		List<CustomerDTO> customers = new ArrayList<>();
		customers.add(customer1); customers.add(customer2);
		
		// mocking service class method
		when(fileHandlingService.readFromFile(anyBoolean())).thenReturn(customers);
		
		ResultActions result = mockMvc.perform(get("/getCustomers?fileType=csv").contentType(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk());		
		
	}

}
