package com.fhtetris.fh_tetris.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scores") // Name der Tabelle in der Datenbank
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatische Generierung der ID
    private Long id;

    @Column(name = "player_name", nullable = false) // Name des Spielers, darf nicht null sein
    private String playerName;

    @Column(nullable = false) // Punktzahl des Spielers, darf nicht null sein
    private int score;

    @Column(nullable = false) // Level des Spielers, darf nicht null sein
    private int level;

    @Column(name = "date_time", nullable = false) // Zeitpunkt, wann der Score erstellt wurde
    private LocalDateTime dateTime;

    // Standard-Konstruktor erforderlich für JPA
    public Score() {
        this.dateTime = LocalDateTime.now(); // Initialisiere das Datum auf das aktuelle Datum
    }

    // Konstruktor, der alle Felder außer ID und Datum initialisiert
    public Score(String playerName, int score, int level) {
        this.playerName = playerName;
        this.score = score;
        this.level = level;
        this.dateTime = LocalDateTime.now(); // Setzt das aktuelle Datum
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
