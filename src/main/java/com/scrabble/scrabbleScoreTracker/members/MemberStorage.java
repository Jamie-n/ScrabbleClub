package com.scrabble.scrabbleScoreTracker.members;

import com.scrabble.scrabbleScoreTracker.database.DatabaseAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

public class MemberStorage {

    private ArrayList<Member> memberList = new ArrayList<Member>();

    public void addMember(Member newMember) {
        memberList.add(newMember);
    }

    public void removeMember(Integer key) {
        memberList.remove(key);
    }

    public Member getMember(Integer key) {
        return memberList.get(key);
    }

    public ArrayList<Member> getAllItems(){
        return memberList;
    }
}
