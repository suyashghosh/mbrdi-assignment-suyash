package com.mbrdi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbrdi.constants.StringConstants;
import com.mbrdi.model.CustomerDTO;
import com.mbrdi.model.StatusMessage;
import com.mbrdi.service.ConsumerFacingService;
import com.mbrdi.validations.CustomerValidations;

@RestController
public class ConsumerFacingController {

	@Autowired
	CustomerValidations customerValidations;

	@Autowired
	ConsumerFacingService consumerFacingService;

	@PostMapping("/store")
	public ResponseEntity<StatusMessage> storeCustomer(@RequestBody CustomerDTO customer, @RequestParam String fileType) {

		// validating request body
		StatusMessage validationStatus = customerValidations.validateRequestBody(customer);
		if(! validationStatus.isStatus()) {
			return new ResponseEntity<>(validationStatus, HttpStatus.BAD_REQUEST);
		}

		// validating the fileType
		StatusMessage fileTypeValidationStatus = customerValidations.validateFileType(fileType);
		if(! fileTypeValidationStatus.isStatus()) {
			return new ResponseEntity<>(fileTypeValidationStatus, HttpStatus.BAD_REQUEST);
		}

		boolean isXmlfile = false;
		if(fileType.trim().toLowerCase().equals("xml")) isXmlfile = true;

		// publish to kafka queue
		if (! consumerFacingService.publishToQueue(customer, false, isXmlfile)) {
			StatusMessage statusMessage = new StatusMessage(false, StringConstants.KAFKA_PUBLISH_ERROR_MESSAGE);
			return new ResponseEntity<>(statusMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		StatusMessage statusMessage = new StatusMessage(true, "Success");
		return new ResponseEntity<>(statusMessage, HttpStatus.OK);
	}

	@GetMapping("/read")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers(@RequestParam String fileType) {
		
		List<CustomerDTO> customers = new ArrayList<>();
		
		// validating the fileType
		StatusMessage fileTypeValidationStatus = customerValidations.validateFileType(fileType);
		if(! fileTypeValidationStatus.isStatus()) {
			return new ResponseEntity<>(customers, HttpStatus.BAD_REQUEST);
		}
		
		// get customers
		customers = consumerFacingService.getCustomers(fileType);
		
		return new ResponseEntity<>(customers, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<StatusMessage> updateCustomer(@RequestBody CustomerDTO customer, @RequestParam String fileType){

		// validating request body
		StatusMessage validationStatus = customerValidations.validateRequestBody(customer);
		if(! validationStatus.isStatus()) {
			return new ResponseEntity<>(validationStatus, HttpStatus.BAD_REQUEST);
		}

		// validating the fileType
		StatusMessage fileTypeValidationStatus = customerValidations.validateFileType(fileType);
		if(! fileTypeValidationStatus.isStatus()) {
			return new ResponseEntity<>(fileTypeValidationStatus, HttpStatus.BAD_REQUEST);
		}

		boolean isXmlfile = false;
		if(fileType.trim().toLowerCase().equals("xml")) isXmlfile = true;

		// publish to kafka queue
		if(! consumerFacingService.publishToQueue(customer, true, isXmlfile)) {
			StatusMessage statusMessage = new StatusMessage(false, StringConstants.KAFKA_PUBLISH_ERROR_MESSAGE);
			return new ResponseEntity<>(statusMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		StatusMessage statusMessage = new StatusMessage(true, "Success");
		return new ResponseEntity<>(statusMessage, HttpStatus.OK);

	}

}
