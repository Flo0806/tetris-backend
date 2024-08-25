package com.fhtetris.fh_tetris.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scores") // Name of the table in the database
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generated id
    private Long id;

    @Column(name = "player_name", nullable = false)
    private String playerName;

    @Column(nullable = false)
    private int score;

    @Column(nullable = false)
    private int level;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    // Standard constructor
    public Score() {
        this.dateTime = LocalDateTime.now();
    }

    public Score(String playerName, int score, int level) {
        this.playerName = playerName;
        this.score = score;
        this.level = level;
        this.dateTime = LocalDateTime.now();
    }

    // Getter und Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    // Optional: Überschreibe toString() für Debugging-Zwecke
    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", playerName='" + playerName + '\'' +
                ", score=" + score +
                ", level=" + level +
                ", dateTime=" + dateTime +
                '}';
    }
}
