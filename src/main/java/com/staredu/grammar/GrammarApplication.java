package com.staredu.grammar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrammarApplication {

	public static void main(String[] args) {
		System.out.println("Spring Boot 애플리케이션이 시작됩니다! - " + java.time.LocalDateTime.now());
		SpringApplication.run(GrammarApplication.class, args);
	}
}
