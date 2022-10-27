package com.ijro_udoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class IjroUdocApplication {
	public static void main(String[] args) {
		SpringApplication.run(IjroUdocApplication.class, args);
	}
}
