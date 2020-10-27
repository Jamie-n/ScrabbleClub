package com.scrabble.scrabbleScoreTracker.controller;


import com.scrabble.scrabbleScoreTracker.members.MemberStorage;
import javafx.scene.control.DatePicker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * The controller class for the scoreboard
 * @author Jamie Neighbours
 * @version October 2020
 *
 *
 */


@Controller
public class ScoreboardController {

    /**
     * Controls the scoreboard page
     *
     *
     * @return the html file to be used
     */

    @GetMapping("/Scoreboard")
    public String scoreboard(Model model) {
        return "leaderboard";
    }
}
