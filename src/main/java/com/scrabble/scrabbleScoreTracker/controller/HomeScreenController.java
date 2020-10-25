package com.scrabble.scrabbleScoreTracker.controller;

import com.scrabble.scrabbleScoreTracker.database.MemberDataService;
import com.scrabble.scrabbleScoreTracker.members.MemberStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.SQLException;

@Controller
public class HomeScreenController {

    @GetMapping("/")
    public RedirectView redirectUser(){
        return new RedirectView("home");
    }


    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/allMembers")
    public String members(Model model) throws SQLException {
        MemberDataService.getAllMemberDataFromDb();
        model.addAttribute("users", MemberStorage.getAllMemberDetails());
        return "allMembers";
    }

    @GetMapping("/Scoreboard")
    public String scoreboard(){
        return "scoreboard";
    }






}
