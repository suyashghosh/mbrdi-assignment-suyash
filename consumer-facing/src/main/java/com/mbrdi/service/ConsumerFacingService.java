package com.mbrdi.service;

import java.util.List;

import com.mbrdi.model.CustomerDTO;

public interface ConsumerFacingService {
	
	public boolean publishToQueue(CustomerDTO customer, boolean isUpdate, boolean isXmlfile);
	
	public List<CustomerDTO> getCustomers(String fileType);

}
