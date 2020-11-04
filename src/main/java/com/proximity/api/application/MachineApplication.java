package com.proximity.api.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author arturo.amapanqui
 * @version 1.0.0
 * */

@SpringBootApplication(scanBasePackages = "com.proximity.api.*")
public class MachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MachineApplication.class, args);
	}

}
