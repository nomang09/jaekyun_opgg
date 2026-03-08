package com.staredu.grammar.controller;

//import com.staredu.grammar.domain.Member;
import com.staredu.grammar.domain.Score;
import com.staredu.grammar.service.GameScoreService;
//import com.staredu.grammar.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ScoreController {

    private GameScoreService gameScoreService;

    @Autowired
    public ScoreController(GameScoreService gameScoreService) {
        this.gameScoreService = gameScoreService;
    }

    @GetMapping(value = "/scores/new")
    public String createForm(){
        return "scores/createScoreForm";
    }

    @PostMapping(value = "/scores/new")
    public String create(ScoreForm form){

        Score score = new Score();
        score.setScore(form.getScore());
        score.setDate(LocalDate.now());


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
}
