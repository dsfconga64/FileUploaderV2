package com.proyecto.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;

@SpringBootApplication
public class FileUploaderProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploaderProjectApplication.class, args);
	}

}