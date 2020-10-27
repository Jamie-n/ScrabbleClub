package com.scrabble.scrabbleScoreTracker.controller;

import com.scrabble.scrabbleScoreTracker.database.MemberDataServiceRetrieve;
import com.scrabble.scrabbleScoreTracker.members.AddUser;
import com.scrabble.scrabbleScoreTracker.members.Member;
import com.scrabble.scrabbleScoreTracker.members.MemberStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.SQLException;

/**
 *
 * The controller class for the homescreen elements
 * @author Jamie Neighbours
 * @version October 2020
 *
 *
 */



@Controller
public class HomeScreenController {

    @GetMapping("/")
    public RedirectView redirectUser() {
        return new RedirectView("home");
    }


    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/allMembers")
    public String members(Model model) throws SQLException {
        MemberStorage.purgeData();
        MemberDataServiceRetrieve.getAllMemberDataFromDb();
        model.addAttribute("users", MemberStorage.getAllMemberDetails());
        return "allMembers";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("member", new Member());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute Member member, Model model) {
        if (AddUser.addUserDb(member)) {
            return "userSuccess";
        } else {

        }
        return null;

    }
}








