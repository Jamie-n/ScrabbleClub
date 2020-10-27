package com.scrabble.scrabbleScoreTracker.controller.search;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchFunction {




    @GetMapping("/searchUser")
    public String searchUser(Model model) {
        model.addAttribute("search", new UserSearchService());
        return "searchBar";
    }

    @PostMapping("/searchUser")
    public String submitSearch(@ModelAttribute UserSearchService service, Model model) {
        model.addAttribute("search", service);
        return "memberData";
    }

}
