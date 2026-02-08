package com.staredu.grammar.service;

import com.staredu.grammar.domain.Member;
import com.staredu.grammar.domain.Score;
import com.staredu.grammar.repository.MemberRepository;
import com.staredu.grammar.repository.ScoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public Long join(Score score) {
        validateDuplicateScore(score);
        scoreRepository.save(score);

        return score.getId();
    }

    private void validateDuplicateScore(Score score) {
        scoreRepository.findByDate(score.getDate())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 날짜입니다.");
                });
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
