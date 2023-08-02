package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.security.GeneralSecurityException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws GeneralSecurityException, IOException {
		FormReader formReader = new FormReader();
		var responses = formReader.readForm();
		SpringApplication.run(DemoApplication.class, args);
	}

}
