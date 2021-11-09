package com.mbrdi.validations;

import com.mbrdi.constants.StringConstants;
import com.mbrdi.model.CustomerDTO;
import com.mbrdi.model.StatusMessage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.*;

import org.springframework.stereotype.Component;

@Component
public class CustomerValidations {
	
	public StatusMessage validateFileType(String fileType) {
		StatusMessage statusMessage = new StatusMessage(false, StringConstants.FILETYPE_ERROR_MESSAGE);
		
		fileType = fileType.trim().toLowerCase();
		if(fileType.equals("csv") || fileType.equals("xml")) {
			statusMessage.setStatus(true);
			statusMessage.setMessage("");
		}
		return statusMessage;
	}
	
	public StatusMessage validateRequestBody(CustomerDTO customer) {
		
		StatusMessage statusMessage = new StatusMessage(true, "");
		String validationMessage = "";
		
		if(! validateName(customer.getName())) {
			statusMessage.setStatus(false);
			if(! validationMessage.equals("")) {
				validationMessage += ", ";
			}
			validationMessage += StringConstants.CUSTOMER_NAME_ERROR_MESSAGE;
			
		}		
		
		if(! validateDob(customer.getDob())) {
			statusMessage.setStatus(false);
			if(! validationMessage.equals("")) {
				validationMessage += ", ";
			}
			validationMessage += StringConstants.CUSTOMER_DOB_ERROR_MESSAGE;
			
		}
			
		if(! validateAge(customer.getAge(), customer.getDob())) {
			statusMessage.setStatus(false);
			if(! validationMessage.equals("")) {
				validationMessage += ", ";
			}
			validationMessage += StringConstants.CUSTOMER_AGE_ERROR_MESSAGE;
			
		}
					
		if(! validateSalary(customer.getSalary())) {
			statusMessage.setStatus(false);
			if(! validationMessage.equals("")) {
				validationMessage += ", ";
			}
			validationMessage += StringConstants.CUSTOMER_SALARY_ERROR_MESSAGE;
			
		}
		
		if(statusMessage.isStatus()) {
			return statusMessage;
		}
		
		statusMessage.setMessage(validationMessage);
		return statusMessage;
		
	}
	
	public boolean validateName(String name) {
		return Pattern.matches("^[A-Za-z]+([a-zA-Z]+[\\s]?)*[A-Za-z]+$", name);
	}
	
	public boolean validateDob(String dob) {	
		
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern(StringConstants.DATE_FORMAT);
			LocalDate date = LocalDate.parse(dob,format);
			if(date.isAfter(LocalDate.now())) return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean validateAge(int age, String dob) {
		
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern(StringConstants.DATE_FORMAT);
			LocalDate birthDate = LocalDate.parse(dob,format);			
			LocalDate today = LocalDate.now();
			int calculatedAge = today.getYear() - birthDate.getYear();
			if(Math.abs(calculatedAge-age) > 1) return false;
			
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean validateSalary(String salary) {
		return Pattern.matches("[\\d]+[\\.]?[\\d]+", salary);
	}

}
