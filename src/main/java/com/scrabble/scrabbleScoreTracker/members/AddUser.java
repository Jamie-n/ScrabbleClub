package com.scrabble.scrabbleScoreTracker.members;

import com.scrabble.scrabbleScoreTracker.database.MemberDataServicePush;

public class AddUser {


    /**
     *
     * When adding a new user to the database
     *
     * @author Jamie Neighbours
     * @version October 2020
     *
     *
     */


    public static boolean addUserDb(Member member){
        try {

            if (member.getFirstName() != null && member.getLastName() != null && member.getPhoneNumber() != null) {
                MemberDataServicePush.pushData(member.getFirstName(), member.getLastName(), member.getPhoneNumber());
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }
}
