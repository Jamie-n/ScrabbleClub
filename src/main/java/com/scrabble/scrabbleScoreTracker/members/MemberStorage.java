package com.scrabble.scrabbleScoreTracker.members;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * The class that  temporarily stores the member objects when being displayed
 *
 * @author Jamie Neighbours
 * @version October 2020
 *
 *
 */

public class MemberStorage {


    private static ArrayList<Integer> memberKeyList = new ArrayList<Integer>();
    private static Hashtable<Integer, Member> memberHashtable = new Hashtable<Integer, Member>();


    public ArrayList<Integer> getMemberKeyList() {
        return memberKeyList;
    }
    public  Member getMember(int key){
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

    public static void purgeData(){
        memberKeyList.clear();
        memberHashtable.clear();
    }
}
