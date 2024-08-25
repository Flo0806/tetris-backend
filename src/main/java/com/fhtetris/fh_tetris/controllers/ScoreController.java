package com.fhtetris.fh_tetris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fhtetris.fh_tetris.entities.Score;
import com.fhtetris.fh_tetris.repositories.ScoreRepository;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = { "http://localhost:3000", "https://fh-softdev.de", "https://www.fh-softdev.de",
        "https://apps.fh-softdev.de" }) // Cross origin for the frontend
public class ScoreController {

    @Autowired
    private ScoreRepository scoreRepository;

    // Get all scores
    @GetMapping
    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    // Save new score
    @PostMapping
    public ResponseEntity<Score> saveScore(@RequestBody Score score) {
        Score savedScore = scoreRepository.save(score);
        return ResponseEntity.ok(savedScore);
    }

    // Get top 10 scores ordered by score, desc
    @GetMapping("/scores")
    public List<Score> getAllScoresSortedByScoreDesc() {
        return scoreRepository.findAllByOrderByScoreDesc();

    }

    // Get score by id
    @GetMapping("/{id}")
    public ResponseEntity<Score> getScoreById(@PathVariable Long id) {
        return scoreRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
