package com.scrabble.scrabbleScoreTracker.controller;

import com.scrabble.scrabbleScoreTracker.database.MemberDataService;
import com.scrabble.scrabbleScoreTracker.members.MemberStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class HomeScreenController {



    @GetMapping("/home")
    public String home(@RequestParam(name = "name", required = false , defaultValue = "World")String name, Model model) throws SQLException {
        return "home";
    }

    @GetMapping("/members")
    public String members(Model model) throws SQLException {
        MemberStorage members = new MemberStorage();

        model.addAttribute("users", MemberDataService.getAllMemberDataFromDb());

        return "allMembers";
    }






}
