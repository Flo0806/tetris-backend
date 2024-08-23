package com.fhtetris.fh_tetris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fhtetris.fh_tetris.entities.Score;
import com.fhtetris.fh_tetris.repositories.ScoreRepository;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "http://localhost:3000") // Erlaubt Cross-Origin-Anfragen vom Frontend
public class ScoreController {

    @Autowired
    private ScoreRepository scoreRepository;

    // Abrufen aller Scores
    @GetMapping
    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    // Speichern eines neuen Scores
    @PostMapping
    public ResponseEntity<Score> saveScore(@RequestBody Score score) {
        Score savedScore = scoreRepository.save(score);
        return ResponseEntity.ok(savedScore);
    }

    // Abrufen eines spezifischen Scores
    @GetMapping("/{id}")
    public ResponseEntity<Score> getScoreById(@PathVariable Long id) {
        return scoreRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
