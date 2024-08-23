package com.fhtetris.fh_tetris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.fhtetris.fh_tetris.*")
@ComponentScan(basePackages = { "com.fhtetris.fh_tetris.*" })
@EntityScan(basePackages = "com.fhtetris.fh_tetris.*") // Scan complete package for entities
public class FhTetrisApplication {

	public static void main(String[] args) {
		SpringApplication.run(FhTetrisApplication.class, args);
	}

}
