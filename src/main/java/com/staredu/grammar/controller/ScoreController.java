package com.staredu.grammar.controller;

import com.staredu.grammar.domain.Score;
import com.staredu.grammar.repository.ScoreRepository;
import com.staredu.grammar.service.GameScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

import com.staredu.grammar.domain.ResetLog;
import com.staredu.grammar.repository.ResetLogRepository;
import java.time.LocalDateTime;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class ScoreController {

    private final GameScoreService gameScoreService;
    private final ScoreRepository scoreRepository;
    private final ResetLogRepository resetLogRepository;

    @Autowired
    public ScoreController(GameScoreService gameScoreService,
                           ScoreRepository scoreRepository,
                           ResetLogRepository resetLogRepository) {

        this.gameScoreService = gameScoreService;
        this.scoreRepository = scoreRepository;
        this.resetLogRepository = resetLogRepository;
    }

    @GetMapping(value = "/scores/new")
    public String createForm(){
        return "scores/createScoreForm";
    }

    @GetMapping("/scores/graph")
    public String graph(Model model){

        List<Score> scores = gameScoreService.findScores();
        model.addAttribute("scores", scores);

        return "scores/scoreGraph";
    }

    @PostMapping(value = "/scores/new")
    public String create(ScoreForm form){

        Score score = new Score();
        score.setScore(form.getScore());
        score.setDate(java.time.LocalDate.now());


        System.out.println("Member name is " + form.getScore());

        gameScoreService.saveScore(score);

        return "redirect:/";
    }
    @GetMapping(value = "scores")
    public String list(Model model){

        List<Score> scores = gameScoreService.findScores();
        model.addAttribute("scores", scores);

        return "scores/scoreList";
    }

    @PostMapping("/scores/reset")
    public String resetScores(String reason) {

        //ResetLog log = new ResetLog();
        //log.setReason(reason);
        //log.setResetTime(LocalDateTime.now());

        //resetLogRepository.save(log);

        scoreRepository.deleteAll();

        return "redirect:/scores";
    }
}
