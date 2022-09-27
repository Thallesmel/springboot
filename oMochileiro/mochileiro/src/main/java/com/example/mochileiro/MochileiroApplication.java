package com.example.mochileiro;

import java.security.Security;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MochileiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MochileiroApplication.class, args);
	}

}
