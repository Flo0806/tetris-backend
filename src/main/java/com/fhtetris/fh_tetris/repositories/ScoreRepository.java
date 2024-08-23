package com.fhtetris.fh_tetris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fhtetris.fh_tetris.entities.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
