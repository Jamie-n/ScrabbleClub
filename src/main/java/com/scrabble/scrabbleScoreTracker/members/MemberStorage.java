package com.scrabble.scrabbleScoreTracker.members;

import com.scrabble.scrabbleScoreTracker.database.DatabaseAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

public class MemberStorage {

    private static ArrayList<Integer> memberKeyList = new ArrayList<Integer>();
    private static Hashtable<Integer, Member> memberHashtable = new Hashtable<Integer, Member>();

    public static ArrayList<Integer> getMemberKeyList() {
        return memberKeyList;
    }

    public static Member getMember(int key){
        return memberHashtable.get(key);
    }

    public static void addMember(int id, Member member){
        memberHashtable.put(id,member);
        memberKeyList.add(id);
    }

    public static ArrayList<Member> getAllMemberDetails(){
        ArrayList<Member> tempMemberList = new ArrayList<>();
        for(Integer key:memberKeyList){
        tempMemberList.add(memberHashtable.get(key));
        }
        return tempMemberList;
    }
}
