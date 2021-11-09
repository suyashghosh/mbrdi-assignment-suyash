package com.mbrdi.fileHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mbrdi.constants.StringConstants;
import com.mbrdi.model.CustomerDTO;

@Component
public class CsvFileHandler {


	public boolean writeToCsv(CustomerDTO customer) {
		String filePath = StringConstants.CSV_FILEPATH;

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath, true);

			fileWriter.append(String.valueOf(customer.getId()));
			fileWriter.append(",");
			fileWriter.append(customer.getName());
			fileWriter.append(",");
			fileWriter.append(customer.getDob());
			fileWriter.append(",");
			fileWriter.append(customer.getSalary());
			fileWriter.append(",");
			fileWriter.append(String.valueOf(customer.getAge()));
			fileWriter.append("\n");

			fileWriter.flush();
			fileWriter.close();

		} catch (Exception ex) {
			return false;
		} 
		return true;
	}

	public boolean updateCsv(CustomerDTO customer) {
		String filePath = StringConstants.CSV_FILEPATH;
		String tempFilePath = "src/main/resources/tempuser.csv";
		
		File file = new File(filePath);

		if(!file.exists()) {
			return false;				
		}

		BufferedReader reader = null;
		FileWriter fileWriter = null;

		try {
			String line = "";
			reader = new BufferedReader(new FileReader(filePath));

			fileWriter = new FileWriter(tempFilePath, true);

			while((line = reader.readLine()) != null) {
				String[] fields = line.split(",");

				if(fields.length > 0 && Integer.valueOf(fields[0]) == customer.getId()) {
					line = customer.getId()+ "," + customer.getName() + "," + customer.getDob() + 
							"," + customer.getSalary() + "," + customer.getAge();
				}
				line += "\n";
				fileWriter.append(line);
			}

			reader.close();
			fileWriter.flush();
			fileWriter.close();

			// delete existing file and remane the temp file as main file
			File oldFile = new File(filePath);
			File newFile = new File(tempFilePath);
			oldFile.delete();
			newFile.renameTo(oldFile);


		} catch (Exception ex) {
			return false;
		} 
		return true;
	}

	public List<CustomerDTO> readFromCsv(){
		String filePath = StringConstants.CSV_FILEPATH;
		
		List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
		File file = new File(filePath);

		if(!file.exists()) {
			return customers;				
		}
		BufferedReader reader = null;

		try {
			String line = "";
			reader = new BufferedReader(new FileReader(filePath));

			while((line = reader.readLine()) != null) {
				String[] fields = line.split(",");

				if(fields.length > 0) {
					CustomerDTO customer = new CustomerDTO();
					customer.setId(Integer.valueOf(fields[0]));
					customer.setName(fields[1]);
					customer.setDob(fields[2]);
					customer.setSalary(fields[3]);
					customer.setAge(Integer.valueOf(fields[4]));
					customers.add(customer);
				}
			}

			reader.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} 

		return customers;
	}

}
