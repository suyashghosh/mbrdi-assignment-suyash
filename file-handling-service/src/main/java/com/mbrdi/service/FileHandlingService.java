package com.mbrdi.service;

import java.util.List;

import com.mbrdi.model.CustomerDTO;

public interface FileHandlingService {
	
	public void consumeFromKafka(byte[] byteArr);
	
	public List<CustomerDTO> readFromFile(boolean isXmlfile);

}
