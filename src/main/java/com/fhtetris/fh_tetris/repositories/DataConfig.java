package com.fhtetris.fh_tetris.repositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.fhtetris.fh_tetris.*")
@ComponentScan(basePackages = { "com.fhtetris.fh_tetris.*" })
@EntityScan(basePackages = "com.fhtetris.fh_tetris.*") // Scan complete package for entities
public class DataConfig {
}