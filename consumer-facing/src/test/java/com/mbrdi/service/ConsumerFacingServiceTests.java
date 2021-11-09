package com.mbrdi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.client.RestTemplate;

import com.mbrdi.constants.StringConstants;
import com.mbrdi.model.CustomerDTO;
import com.mbrdi.protobufs.CustomerProto;
import com.mbrdi.protobufs.CustomerTransferProto;

@SpringBootTest
public class ConsumerFacingServiceTests {

	@InjectMocks
	CustomerFacingServiceImpl customerFacingService;

	@Mock
	KafkaTemplate<String, byte[]> kafkaTemplate;

	@Mock
	RestTemplate restTemplate;

	@Test
	public void testPublishToQueue() {
		CustomerDTO customer = new CustomerDTO(1, "Suyash Ghosh", "10-05-1997", 24, "1520000");

		//converting to google protocol buffer
		CustomerProto customerProto = CustomerProto.newBuilder().setId(customer.getId()).setName(customer.getName())
				.setDob(customer.getDob()).setAge(customer.getAge()).setSalary(customer.getSalary()).build();

		CustomerTransferProto customerTransferProto = CustomerTransferProto.newBuilder().setIsUpdate(true)
				.setIsXmlfile(true).addCustomers(customerProto).build();

		//encoding to byteArray
		byte[] customerByteArr = customerTransferProto.toByteArray();

		// mocking the kafka template
		when(kafkaTemplate.send(StringConstants.KAFKA_TOPIC, customerByteArr)).thenReturn(null);

		//checking expected vs actual
		boolean isPublished = customerFacingService.publishToQueue(customer, true, true);
		assertThat(isPublished).isEqualTo(true);
	}

	@Test
	public void testGetCustomers() {
		CustomerDTO customer1 = new CustomerDTO(1, "suyash", "10-05-1997", 24, "1500000.25");
		CustomerDTO customer2 = new CustomerDTO(2, "john", "21-11-1997", 24, "8500700");

		List<CustomerDTO> customers = new ArrayList<>();
		customers.add(customer1); customers.add(customer2);

		// creating protobuf object
		List<CustomerProto> customerProtos = new ArrayList<>();
		for(CustomerDTO customer : customers) {
			CustomerProto customerProto = CustomerProto.newBuilder().setId(customer.getId()).
					setName(customer.getName()).setDob(customer.getDob()).
					setSalary(customer.getSalary()).setAge(customer.getAge()).build();
			customerProtos.add(customerProto);
		}
		CustomerTransferProto customerTransferProto = CustomerTransferProto.newBuilder().
				addAllCustomers(customerProtos).build();
		
		// mocking the rest template
		String csvFileUrl = StringConstants.READ_FILE_URL + "?fileType=" + "csv";
		String xmlFileUrl = StringConstants.READ_FILE_URL + "?fileType=" + "xml";
		
		when(restTemplate.getForEntity(csvFileUrl , CustomerTransferProto.class))
		.thenReturn(new ResponseEntity<>(customerTransferProto, HttpStatus.OK));
		
		when(restTemplate.getForEntity(xmlFileUrl , CustomerTransferProto.class))
		.thenReturn(new ResponseEntity<>(customerTransferProto, HttpStatus.OK));
		
		// checking the method output with expected output
		List<CustomerDTO> resultCustomers = customerFacingService.getCustomers("xml");
		assertThat(resultCustomers.size()).isEqualTo(customers.size());
		for(int i = 0; i<resultCustomers.size(); i++) {
			assertThat(resultCustomers.get(i).getId()).isEqualTo(customers.get(i).getId());
		}
		
	}

}
