package com.springCloud.serviceexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ServiceExampleApplication {

	@Value("${service.instance.name}")
	private String instance;

	public static void main(String[] args) {
		SpringApplication.run(ServiceExampleApplication.class, args);
	}

	@RequestMapping("/ping")
	public String pingMessage(){
		return "Hello from " + instance;
	}

	@RequestMapping("/")
	public String message(){
		return "Root message from " + instance;
	}
}
