package com.capg.mra.mobilerechargeapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * @author Boola Rohan
 * @author Sumani
 *
 */
/** 
 * @SpringBootApplication annotation can be used to enable those three features that is:
 * inside package org.springframework.boot.SpringApplication;
 * @EnableAutoConfiguration: enable Spring Boot’s auto-configuration mechanism
 * @ComponentScan: enable @Component scan on the package where the application is located (see the best practices)
 * @Configuration: allow to register extra beans in the context or import additional configuration classes
 * @EnableDiscoveryClient enable the service as discovery client
 * 
 * **/
@SpringBootApplication
@EnableEurekaClient
public class MraMobileRechargeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MraMobileRechargeApplication.class, args);
	}

	/**
	 * @Bean annotation tells that a method produces a bean to be managed by the Spring container
	 * @return RestTemplate
	 */
	@Bean 
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}
