package com.mbrdi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mbrdi.fileHandling.CsvFileHandler;
import com.mbrdi.fileHandling.XmlFileHandler;
import com.mbrdi.model.CustomerDTO;
import com.mbrdi.protobufs.CustomerProto;
import com.mbrdi.protobufs.CustomerTransferProto;

@SpringBootTest
public class FileHandlingServiceTests {
	
	@InjectMocks
	private FileHandlingServiceImpl fileHandlingService;
	
	@Mock
	CsvFileHandler csvFileHandler;
	
	@Mock
	XmlFileHandler xmlFileHandler;
	
	@Test
	public void testReadFromFile() {
		CustomerDTO customer = new CustomerDTO(1, "suyash ghosh", "10-05-1997", 24, "1500000.25");
		List<CustomerDTO> expectedCustomers = new ArrayList<>();
		expectedCustomers.add(customer);
		
		// mock file handler methods
		when(xmlFileHandler.readFromXml()).thenReturn(expectedCustomers);
		when(csvFileHandler.readFromCsv()).thenReturn(expectedCustomers);
		
		List<CustomerDTO> actualCustomers = fileHandlingService.readFromFile(false);
		assertThat(actualCustomers.size()).isEqualTo(expectedCustomers.size());
		assertThat(actualCustomers.get(0).toString()).isEqualTo(expectedCustomers.get(0).toString());
	}
	
	@Test
	public void testConsumeFromKafka() {
		// creating protobuf object
		CustomerProto customerProto = CustomerProto.newBuilder().setId(1).setName("Suyash Ghosh")
				.setDob("10-05-1997").setAge(24).setSalary("1520000").build();
		
		CustomerTransferProto customerTransferProto = CustomerTransferProto.newBuilder().setIsUpdate(true)
				.setIsXmlfile(true).addCustomers(customerProto).build();
		
		//encoding to byteArray
		byte[] customerByteArr = customerTransferProto.toByteArray();
		
		// mock file handler methods
		when(xmlFileHandler.writeToXml(any(CustomerDTO.class))).thenReturn(true);
		when(xmlFileHandler.updateXml(any(CustomerDTO.class))).thenReturn(true);
		
		when(csvFileHandler.writeToCsv(any(CustomerDTO.class))).thenReturn(true);
		when(csvFileHandler.updateCsv(any(CustomerDTO.class))).thenReturn(true);

		assertDoesNotThrow(() -> fileHandlingService.consumeFromKafka(customerByteArr));
	}

}
