package com.scrabble.scrabbleScoreTracker.controller;

import com.scrabble.scrabbleScoreTracker.database.DatabaseAccess;
import com.scrabble.scrabbleScoreTracker.database.MemberDataService;
import com.scrabble.scrabbleScoreTracker.members.Member;

public class AddUser {


    public static boolean addUserDb(Member member){
        try {
            if (member.getId() != 0 && member.getFirstName() != null && member.getLastName() != null && member.getPhoneNumber() != null) {
                DatabaseAccess.pushData(member.getId(), member.getFirstName(), member.getLastName(), member.getPhoneNumber());
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }
}
