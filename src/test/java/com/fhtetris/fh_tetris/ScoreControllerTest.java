package com.fhtetris.fh_tetris;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.fhtetris.fh_tetris.controllers.ScoreController;
import com.fhtetris.fh_tetris.entities.Score;
import com.fhtetris.fh_tetris.repositories.ScoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ScoreController.class, excludeAutoConfiguration = {
                DataSourceAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class,
                JpaRepositoriesAutoConfiguration.class
})
public class ScoreControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockitoBean
        private ScoreRepository scoreRepository;

        private Score score1;
        private Score score2;

        @BeforeEach
        public void setup() {
                score1 = new Score();
                score1.setId(1L);
                score1.setPlayerName("Player1");
                score1.setScore(100);

                score2 = new Score();
                score2.setId(2L);
                score2.setPlayerName("Player2");
                score2.setScore(200);
        }

        @Test
        public void testGetAllScores() throws Exception {
                when(scoreRepository.findAll()).thenReturn(Arrays.asList(score1, score2));

                mockMvc.perform(get("/api/scores")
                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$[0].playerName").value("Player1"))
                                .andExpect(jsonPath("$[1].playerName").value("Player2"));
        }

        @Test
        public void testGetScoreById() throws Exception {
                when(scoreRepository.findById(1L)).thenReturn(Optional.of(score1));

                mockMvc.perform(get("/api/scores/1")
                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.playerName").value("Player1"));
        }

        @Test
        public void testSaveScore() throws Exception {
                when(scoreRepository.save(Mockito.any(Score.class))).thenReturn(score1);

                mockMvc.perform(post("/api/scores")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"playerName\":\"Player1\", \"score\":100}"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.playerName").value("Player1"))
                                .andExpect(jsonPath("$.score").value(100));
        }

        @Test
        public void testGetScoreByIdNotFound() throws Exception {
                when(scoreRepository.findById(1L)).thenReturn(Optional.empty());

                mockMvc.perform(get("/api/scores/1")
                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(status().isNotFound());
        }
}
