package com.scrabble.scrabbleScoreTracker.controller;

import com.scrabble.scrabbleScoreTracker.database.MemberDataService;
import com.scrabble.scrabbleScoreTracker.members.Member;
import com.scrabble.scrabbleScoreTracker.members.MemberStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.sql.SQLException;

@Controller
public class HomeScreenController {


    @GetMapping("/")
    public String splashScreen(){
        return "splashScreen";
    }

    @GetMapping("/home")
    public String home(String name, Model model) throws SQLException {
        return "home";
    }

    @GetMapping("/members")
    public String members(Model model) throws SQLException {
        model.addAttribute("users", MemberStorage.getAllMemberDetails());
        MemberDataService.getAllMemberDataFromDb();
        return "allMembers";
    }






}
