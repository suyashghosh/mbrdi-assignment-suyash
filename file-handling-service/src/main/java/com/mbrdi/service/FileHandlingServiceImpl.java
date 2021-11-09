package com.mbrdi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.mbrdi.constants.StringConstants;
import com.mbrdi.fileHandling.CsvFileHandler;
import com.mbrdi.fileHandling.XmlFileHandler;
import com.mbrdi.model.CustomerDTO;
import com.mbrdi.protobufs.CustomerProto;
import com.mbrdi.protobufs.CustomerTransferProto;

@Service
public class FileHandlingServiceImpl implements FileHandlingService {

	@Autowired
	CsvFileHandler csvFileHandler;

	@Autowired
	XmlFileHandler xmlFileHandler;

	@KafkaListener(topics = StringConstants.KAFKA_TOPIC, groupId = StringConstants.KAFKA_GROUP_ID,
			containerFactory = "userKafkaListenerFactory")
	@Override
	public void consumeFromKafka(byte[] byteArr) {

		try {

			// decoding byteArray to google protobuf
			CustomerTransferProto customerTransferProto = CustomerTransferProto.parseFrom(byteArr);
			System.out.println(customerTransferProto);
			if(customerTransferProto.getCustomersList().size() == 0) {
				return;
			}
			CustomerProto customerProto = customerTransferProto.getCustomers(0);

			// initializing to DTO object from protobuf object
			CustomerDTO customer = new CustomerDTO();
			customer.setId(customerProto.getId());
			customer.setName(customerProto.getName());
			customer.setDob(customerProto.getDob());
			customer.setSalary(customerProto.getSalary());
			customer.setAge(customerProto.getAge());

			// write or update to file
			if(customerTransferProto.getIsXmlfile()) {
				if(customerTransferProto.getIsUpdate()) {
					xmlFileHandler.updateXml(customer);
				}else {
					xmlFileHandler.writeToXml(customer);
				}
			}else {
				if(customerTransferProto.getIsUpdate()) {
					csvFileHandler.updateCsv(customer);
				}else {
					csvFileHandler.writeToCsv(customer);
				}
			}

		}catch (Exception e) {

		}
	}

	@Override
	public List<CustomerDTO> readFromFile(boolean isXmlfile) {
		List<CustomerDTO> customers = new ArrayList<>();
		if(isXmlfile) {
			customers = xmlFileHandler.readFromXml();
		}else {
			customers = csvFileHandler.readFromCsv();
		}
				
		return customers;
	}

}
