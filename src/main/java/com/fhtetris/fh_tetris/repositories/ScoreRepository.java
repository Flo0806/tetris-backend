package com.fhtetris.fh_tetris.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fhtetris.fh_tetris.entities.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    @Query(value = "SELECT s FROM Score s ORDER BY s.score DESC LIMIT 10")
    List<Score> findAllByOrderByScoreDesc();
}
