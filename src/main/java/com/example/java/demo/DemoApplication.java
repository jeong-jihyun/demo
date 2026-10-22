package com.example.java.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// controller 패키지(com.example.java.controller)까지 스캔하려면 상위 패키지를 지정해야 한다.
@SpringBootApplication(scanBasePackages = "com.example.java")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
