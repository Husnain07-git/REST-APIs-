package com.ornesol.edutech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class EdutechApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdutechApplication.class, args);
	}

}
