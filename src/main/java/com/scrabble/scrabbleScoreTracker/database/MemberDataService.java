package com.scrabble.scrabbleScoreTracker.database;

import com.scrabble.scrabbleScoreTracker.members.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDataService {


    public static ArrayList<Member> getAllMemberDataFromDb() throws SQLException {
        ResultSet resultSet = DatabaseAccess.retrieveData("SELECT * FROM members");
        ArrayList<Member> memberList = new ArrayList<>();
        while (resultSet.next()) {//Creates a list of members from the database
            memberList.add(new Member(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("last name")));
        }
        return memberList;
}

}
