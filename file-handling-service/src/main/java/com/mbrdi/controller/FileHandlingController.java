package com.mbrdi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbrdi.model.CustomerDTO;
import com.mbrdi.protobufs.CustomerProto;
import com.mbrdi.protobufs.CustomerTransferProto;
import com.mbrdi.service.FileHandlingService;

@RestController
public class FileHandlingController {
	
	@Autowired
	FileHandlingService fileHandlingService;
	
	@GetMapping(path = "/getCustomers", produces = "application/x-protobuf")
	public CustomerTransferProto getCustomers(@RequestParam String fileType) {
		
		List<CustomerProto> customerProtos = new ArrayList<>();
		boolean isXmlfile = false;
		fileType = fileType.trim().toLowerCase();
		if(fileType.equals("xml")) isXmlfile = true;
		
		// get customers from the corresponding fileType
		List<CustomerDTO> customers = fileHandlingService.readFromFile(isXmlfile);
		
		// wraping protobuf object to DTO object
		for(CustomerDTO customer : customers) {
			CustomerProto customerProto = CustomerProto.newBuilder().setId(customer.getId()).
					setName(customer.getName()).setDob(customer.getDob()).
					setSalary(customer.getSalary()).setAge(customer.getAge()).build();
			customerProtos.add(customerProto);
		}
		
		// send protobuf object over rest api
		CustomerTransferProto customerTransferProto = CustomerTransferProto.newBuilder().
				addAllCustomers(customerProtos).build();
		
		return customerTransferProto;
		
	}

}
