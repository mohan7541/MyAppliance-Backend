package com.appliance.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@SpringBootApplication
@EntityScan("com.appliance.models")
@Configuration
@EnableJpaRepositories("com.appliance.repositories")
@ComponentScan(basePackages = { "com.appliance.application", "com.appliance.service", "com.appliance.web",
		"com.appliance.repositories", "com.appliance.exception‰" })
public class ApplianceApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(ApplianceApplication.class, args);

	}
   

}
