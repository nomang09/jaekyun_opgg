package com.staredu.grammar.service;

import com.staredu.grammar.domain.Score;
import com.staredu.grammar.repository.ScoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GameScoreService {

    private final ScoreRepository scoreRepository;

    @Autowired
    public GameScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    /**
     * 회원가입
     */
    public void saveScore(Score score) {

        Optional<Score> existing = scoreRepository.findByDate(score.getDate());

        if (existing.isPresent()) {
            existing.get().setScore(score.getScore());
        } else {
            scoreRepository.save(score);
        }
    }

    /**
     * 전체 회원 조회
     */
    public List<Score> findScores(){
        return scoreRepository.findAll();
    }

    /**
     * 회원 일련번호 조회
     */
    public Optional<Score> findOne(LocalDate scoreDate) {
        return scoreRepository.findByDate(scoreDate);
    }
}
