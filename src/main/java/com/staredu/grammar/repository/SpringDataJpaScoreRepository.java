package com.staredu.grammar.repository;

import com.staredu.grammar.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaScoreRepository extends JpaRepository<Score, Long>, ScoreRepository {

    Optional<Score> findByScore(Integer score);
}
