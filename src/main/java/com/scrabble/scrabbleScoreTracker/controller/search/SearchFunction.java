package com.scrabble.scrabbleScoreTracker.controller.search;

import com.scrabble.scrabbleScoreTracker.AlertMessage;
import com.scrabble.scrabbleScoreTracker.database.MemberDataServiceRetrieve;
import com.scrabble.scrabbleScoreTracker.members.Member;
import com.scrabble.scrabbleScoreTracker.members.MemberStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SearchFunction {


    @GetMapping("/searchUser")
    public String searchUser(Model model) {
        model.addAttribute("search", new UserSearchService());
        return "searchBar";
    }

    @PostMapping("/searchUser")
    public String submitSearch(@ModelAttribute SearchInterface service,SearchInterface selectId, Model model) {
        model.addAttribute("search", service);
        model.addAttribute("searchIndex",selectId);

        if(MemberDataServiceRetrieve.findMembers(service.getSearchValue())) {
            model.addAttribute("member", MemberStorage.getAllMemberDetails());
            return "memberData";
        }else {
            model.addAttribute("message", new AlertMessage("User Not Found Please Search Again"));
            return "userAlert";
        }
    }

    @RequestMapping(value = "/selectUser", method = RequestMethod.POST)
    public String selectUser(@RequestParam(defaultValue="0") String name){
        System.out.println(name);
        return "home";
    }

}
