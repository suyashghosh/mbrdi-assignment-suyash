package com.mbrdi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mbrdi.controller.ConsumerFacingController;

@SpringBootTest
class ConsumerFacingApplicationTests {

	@Autowired
	private ConsumerFacingController controller;

	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
	

}
