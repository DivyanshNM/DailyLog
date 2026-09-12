package com.DailyLog.retrieval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RetrievalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetrievalApplication.class, args);
	}

}
