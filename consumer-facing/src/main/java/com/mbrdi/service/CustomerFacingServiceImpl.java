package com.mbrdi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mbrdi.constants.StringConstants;
import com.mbrdi.model.CustomerDTO;
import com.mbrdi.protobufs.CustomerProto;
import com.mbrdi.protobufs.CustomerTransferProto;

@Service
public class CustomerFacingServiceImpl implements ConsumerFacingService {

	@Autowired
    private KafkaTemplate<String, byte[]> kafkaTemplate;
    
    @Autowired
    private RestTemplate restTemplate;
	
	@Override
	public boolean publishToQueue(CustomerDTO customer, boolean isUpdate, boolean isXmlfile) {
		
		try {
			//converting to google protocol buffer
			CustomerProto customerProto = CustomerProto.newBuilder().setId(customer.getId()).setName(customer.getName())
					.setDob(customer.getDob()).setAge(customer.getAge()).setSalary(customer.getSalary()).build();
			
			CustomerTransferProto customerTransferProto = CustomerTransferProto.newBuilder().setIsUpdate(isUpdate)
					.setIsXmlfile(isXmlfile).addCustomers(customerProto).build();
			
			//encoding to byteArray
			byte[] customerByteArr = customerTransferProto.toByteArray();
			
			// publish to kafka
			kafkaTemplate.send(StringConstants.KAFKA_TOPIC, customerByteArr);
			
		}catch(Exception e) {
			return false;
		}
				
		return true;
	}

	@Override
	public List<CustomerDTO> getCustomers(String fileType) {

		List<CustomerDTO> customers = new ArrayList<>();
		String url = StringConstants.READ_FILE_URL + "?fileType=" + fileType;
		
		// calling second service to fetch customers
		ResponseEntity<CustomerTransferProto> responseEntity = restTemplate.getForEntity(url , CustomerTransferProto.class);
		
		if(responseEntity.getStatusCodeValue() == 200 && responseEntity.getBody() != null) {
			List<CustomerProto> customerProtos = responseEntity.getBody().getCustomersList();
			
			// wraping DTO object to protobuf object
			customers = customerProtos.stream().map(customerProto -> new CustomerDTO(customerProto.getId(),
					customerProto.getName(), customerProto.getDob(), customerProto.getAge(),
					customerProto.getSalary())).collect(Collectors.toList());

		}		
		return customers;
	}

	
}
