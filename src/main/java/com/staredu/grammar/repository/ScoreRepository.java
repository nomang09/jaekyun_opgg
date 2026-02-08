package com.staredu.grammar.repository;

import com.staredu.grammar.domain.Score;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ScoreRepository {

    Score save(Score score);
    Optional<Score> findByDate(LocalDate date);
    //Optional<Score> findByScore(Integer score);
    List<Score> findAll();
}
