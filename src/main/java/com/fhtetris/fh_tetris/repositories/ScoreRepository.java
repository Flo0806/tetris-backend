package com.fhtetris.fh_tetris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fhtetris.fh_tetris.entities.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
