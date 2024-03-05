package com.victorleandro.challengenotesai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ChallengeNotesAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeNotesAiApplication.class, args);
	}

}
