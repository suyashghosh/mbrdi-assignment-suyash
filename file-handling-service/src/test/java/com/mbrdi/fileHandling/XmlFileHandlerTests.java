package com.mbrdi.fileHandling;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mbrdi.constants.StringConstants;
import com.mbrdi.model.CustomerDTO;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class XmlFileHandlerTests {
	
	@Autowired
	private XmlFileHandler xmlFileHandler;
	
	@Test
	@Order(1)
	public void testWriteToXml() {
		deleteExistingXml();
		
		CustomerDTO customer = new CustomerDTO(1, "suyash", "10-05-1997", 24, "1500000.25");
		boolean isWritten;
		isWritten = xmlFileHandler.writeToXml(customer);
		assertThat(isWritten).isEqualTo(true);		
	}
	
	@Test
	@Order(2)
	public void testUpdateXml() {
		CustomerDTO customer = new CustomerDTO(1, "suyash ghosh", "10-05-1997", 24, "1500000.25");
		boolean isUpdated;
		isUpdated = xmlFileHandler.updateXml(customer);
		assertThat(isUpdated).isEqualTo(true);
	}
	
	@Test
	@Order(3)
	public void testReadFromXml() {
		CustomerDTO customer = new CustomerDTO(1, "suyash ghosh", "10-05-1997", 24, "1500000.25");
		List<CustomerDTO> expectedCustomers = new ArrayList<>();
		expectedCustomers.add(customer);
		
		List<CustomerDTO> actualCustomers = xmlFileHandler.readFromXml();
		assertThat(actualCustomers.get(0).getName()).isEqualTo(expectedCustomers.get(0).getName());	
		deleteExistingXml();;
	}
	
	private void deleteExistingXml() {
		File file = new File(StringConstants.XML_FILEPATH);
		file.delete();
	}

}
