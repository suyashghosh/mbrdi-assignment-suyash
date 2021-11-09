package com.mbrdi.validations;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mbrdi.constants.StringConstants;
import com.mbrdi.validations.CustomerValidations;

@SpringBootTest
public class ConsumerFacingUserInputTests {

	@Autowired
	private CustomerValidations customerValidations;

	@Test
	void testCustomerName() throws Exception {
		boolean isCorrect;

		isCorrect = customerValidations.validateName("123");
		assertThat(isCorrect).isEqualTo(false);

		isCorrect = customerValidations.validateName("  suyash");
		assertThat(isCorrect).isEqualTo(false);

		isCorrect = customerValidations.validateName("suyash  ");
		assertThat(isCorrect).isEqualTo(false);

		isCorrect = customerValidations.validateName("suyash   ghosh");
		assertThat(isCorrect).isEqualTo(false);

		isCorrect = customerValidations.validateName("suyash12");
		assertThat(isCorrect).isEqualTo(false);

		isCorrect = customerValidations.validateName("suya$h");
		assertThat(isCorrect).isEqualTo(false);

		isCorrect = customerValidations.validateName("suyash ghosh");
		assertThat(isCorrect).isEqualTo(true);

		isCorrect = customerValidations.validateName("Mr Suyash Ghosh");
		assertThat(isCorrect).isEqualTo(true);
	}

	@Test
	void testCustomerDob() throws Exception {
		
		LocalDate futureDate = LocalDate.now().plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(StringConstants.DATE_FORMAT);
		String futureDateString = futureDate.format(formatter);
		
		boolean isCorrect;

		isCorrect = customerValidations.validateDob("12-09-1997");
		assertThat(isCorrect).isEqualTo(true);
		
		isCorrect = customerValidations.validateDob("12/09/1997");
		assertThat(isCorrect).isEqualTo(false);
		
		isCorrect = customerValidations.validateDob("12-13-1997");
		assertThat(isCorrect).isEqualTo(false);
		
		isCorrect = customerValidations.validateDob("12-9-1997");
		assertThat(isCorrect).isEqualTo(false);
		
		isCorrect = customerValidations.validateDob("12-09-97");
		assertThat(isCorrect).isEqualTo(false);
		
		isCorrect = customerValidations.validateDob(futureDateString);
		assertThat(isCorrect).isEqualTo(false);

	}
	
	@Test
	void testSalary() throws Exception {
		
		boolean isCorrect;

		isCorrect = customerValidations.validateSalary("two");
		assertThat(isCorrect).isEqualTo(false);
		
		isCorrect = customerValidations.validateSalary("Rs 300");
		assertThat(isCorrect).isEqualTo(false);
		
		isCorrect = customerValidations.validateSalary("231232.432");
		assertThat(isCorrect).isEqualTo(true);
		
		isCorrect = customerValidations.validateSalary("15007682");
		assertThat(isCorrect).isEqualTo(true);
		
	}
	
	@Test
	void testAge() throws Exception {
		String dob = "10-05-1997";
		
		boolean isCorrect;
		
		isCorrect = customerValidations.validateAge(26, dob);
		assertThat(isCorrect).isEqualTo(false);
		
		isCorrect = customerValidations.validateAge(-1, dob);
		assertThat(isCorrect).isEqualTo(false);
		
		isCorrect = customerValidations.validateAge(24, dob);
		assertThat(isCorrect).isEqualTo(true);
		
	}
	
	void testFileType() throws Exception {
		boolean isCorrect;
		
		isCorrect = customerValidations.validateFileType("xml").isStatus();
		assertThat(isCorrect).isEqualTo(true);
		
		isCorrect = customerValidations.validateFileType("csv").isStatus();
		assertThat(isCorrect).isEqualTo(true);
		
		isCorrect = customerValidations.validateFileType("pdf").isStatus();
		assertThat(isCorrect).isEqualTo(false);
		
		isCorrect = customerValidations.validateFileType("doc").isStatus();
		assertThat(isCorrect).isEqualTo(false);
		
	}

}
