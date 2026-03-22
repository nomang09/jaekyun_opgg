package com.staredu.grammar.service;

import com.staredu.grammar.domain.Score;
import com.staredu.grammar.repository.ScoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ScoreServiceTest {

    @Autowired
    GameScoreService gamescoreService;

    @Autowired
    ScoreRepository scoreRepository;

//     @BeforeEach
//    public void beforeEach() {
//        scoreRepository = new ScoreRepository();
//        memberService = new MemberService(scoreRepository);
//    }

 //   @AfterEach
    //     public void afterEach() {
//        memberRepository.clearstore();
//    }

    @Test
    void 점수입력() throws Exception{
        //Given
        Score score = new Score();
        score.setScore(100);
        score.setDate(LocalDate.now());

        //When
        gamescoreService.saveScore(score);
        LocalDate saveScore = score.getDate();

        //then
        Score findScore = scoreRepository.findByDate(saveScore).get();
        assertThat(findScore.getDate()).isEqualTo(saveScore);
    }

//    @Test
//    void 중복_점수_예외() throws Exception{
//        //Given
//        Score score1 = new Score();
//        score1.setScore(100);
//
//        Score score2 = new Score();
//        score2.setScore(200);
//
//        //When
//        gamescoreService.saveScore(score1);
//        /*
//        try {
//            memberService.join(member2);
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
//        */
//        IllegalStateException e = assertThrows(IllegalStateException.class, () -> gamescoreService.saveScore(score2));
//
//        assertThat(e.getMessage()).isEqualTo("이미 존재하는 점수입니다.");
//        //Then
//    }

    @Test
    void 같은_날짜_마지막_점수_저장() {

        LocalDate today = LocalDate.now();

        Score score1 = new Score();
        score1.setScore(10);
        score1.setDate(today);

        Score score2 = new Score();
        score2.setScore(30);
        score2.setDate(today);

        gamescoreService.saveScore(score1);
        gamescoreService.saveScore(score2);

        Score result = scoreRepository.findByDate(today).get();

        assertThat(result.getScore()).isEqualTo(30);
    }

    @Test
    void findOne() {
    }
}