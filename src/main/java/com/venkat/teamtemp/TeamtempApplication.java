package com.venkat.teamtemp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing

public class TeamtempApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamtempApplication.class, args);
	}
}
