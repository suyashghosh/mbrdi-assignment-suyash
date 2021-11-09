package com.mbrdi.fileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mbrdi.constants.StringConstants;
import com.mbrdi.model.CustomerDTO;

@Component
public class XmlFileHandler {

	public boolean writeToXml(CustomerDTO customer) {

		String filePath = StringConstants.XML_FILEPATH;

		try {
			File file = new File(filePath);
			List<CustomerDTO> customers = new ArrayList<>();

			if(file.exists()) {
				customers = readFromXml();				
			}

			customers.add(customer);
			ObjectMapper mapper = new XmlMapper();
			mapper.writeValue(file, customers);

		}catch(Exception e){
			return false;
		}
		return true;
	}

	public boolean updateXml(CustomerDTO customer) {
		String filePath = StringConstants.XML_FILEPATH;

		try {
			File file = new File(filePath);
			List<CustomerDTO> customers = new ArrayList<>();

			if(!file.exists()) {
				return false;				
			}
			customers = readFromXml();

			for(CustomerDTO oldCustomer : customers) {
				if(oldCustomer.getId() == customer.getId()) {
					oldCustomer.setName(customer.getName());
					oldCustomer.setDob(customer.getDob());
					oldCustomer.setSalary(customer.getSalary());
					oldCustomer.setAge(customer.getAge());
				}
			}
			ObjectMapper mapper = new XmlMapper();
			mapper.writeValue(file, customers);

		}catch(Exception e){
			return false;
		}
		return true;
	}

	public List<CustomerDTO> readFromXml(){

		String filePath = StringConstants.XML_FILEPATH;
		List<CustomerDTO> customers = new ArrayList<>();
		try {
			File file = new File(filePath);
			if(file.exists()) {
				ObjectMapper mapper = new XmlMapper();
				InputStream inputStream = new FileInputStream(file);
				TypeReference<List<CustomerDTO>> typeReference = new TypeReference<List<CustomerDTO>>() {};
				customers = mapper.readValue(inputStream, typeReference);
			}

		}catch(Exception e) {

		}
		return customers;
	}

}
