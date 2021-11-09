package com.mbrdi.fileHandling;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mbrdi.constants.StringConstants;
import com.mbrdi.model.CustomerDTO;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CsvFileHandlerTests {
	
	@Autowired
	private CsvFileHandler csvFileHandler;
	
	@Test
	@Order(1)
	public void testWriteToCsv() throws Exception {
		deleteExistingCsv();
		
		CustomerDTO customer = new CustomerDTO(1, "suyash", "10-05-1997", 24, "1500000.25");
		boolean isWritten;
		isWritten = csvFileHandler.writeToCsv(customer);
		assertThat(isWritten).isEqualTo(true);
	}
	
	@Test
	@Order(2)
	public void testUpdateCsv() throws Exception {
		CustomerDTO customer = new CustomerDTO(1, "suyash ghosh", "10-05-1997", 24, "1500000.25");
		boolean isUpdated;
		isUpdated = csvFileHandler.updateCsv(customer);
		assertThat(isUpdated).isEqualTo(true);
	}
	
	@Test
	@Order(3)
	public void testReadFromCsv() throws Exception {
		CustomerDTO customer = new CustomerDTO(1, "suyash ghosh", "10-05-1997", 24, "1500000.25");
		List<CustomerDTO> expectedCustomers = new ArrayList<>();
		expectedCustomers.add(customer);
		
		List<CustomerDTO> actualCustomers = csvFileHandler.readFromCsv();
		assertThat(actualCustomers.get(0).getName()).isEqualTo(expectedCustomers.get(0).getName());	
		deleteExistingCsv();
	}
	
	private void deleteExistingCsv() {
		File file = new File(StringConstants.CSV_FILEPATH);
		file.delete();
	}

}
