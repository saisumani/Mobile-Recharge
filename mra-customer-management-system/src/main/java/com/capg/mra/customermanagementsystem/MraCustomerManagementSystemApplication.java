package com.capg.mra.customermanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class MraCustomerManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MraCustomerManagementSystemApplication.class, args);
	}

}
