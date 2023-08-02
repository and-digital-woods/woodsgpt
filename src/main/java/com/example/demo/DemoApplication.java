package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.security.GeneralSecurityException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws GeneralSecurityException, IOException {
		ResponseReader reader = new ResponseReader();
		var responses = reader.GetResponses();
		SpringApplication.run(DemoApplication.class, args);
	}

}
