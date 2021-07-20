package com.springCloud.configClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConfigClientApplication {

	@Autowired
	private ConfigClientAppConfiguration properties;

	@Value("${some.other.property}")
	private String someOtherProperty; //This property is set in config-server.

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}


	@RequestMapping
	public String printConfig(){
		StringBuilder sb = new StringBuilder();
		sb.append(properties.getProperty()); // > Este valor lo obtiene del archivo 'config-client-app.properties' (propiedad some.property) en el repo de github. (Del archivo global del client config)
		sb.append(" || ");
		sb.append(someOtherProperty); // > Este valor lo obtiene del archivo application.properties (propiedad some.other.property) en el repo github. (Es decir, del archivo global de configuraciones)

		return sb.toString();
	}
}
