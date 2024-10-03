package com.microservice_transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceTransactionApplication.class, args);
	}

}
