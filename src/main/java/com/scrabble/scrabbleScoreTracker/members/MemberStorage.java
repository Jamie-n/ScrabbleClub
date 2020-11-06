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

    /**
     * Add a new member to the hash table
     *
     * @param id - The key
     * @param member - The new member class to be added
     */

    public static void addMember(int id, Member member){
        memberHashtable.put(id,member);
        memberKeyList.add(id);
    }

    /**
     * Pulls all members stored in the hash table
     *
     *
     * @return - An array list of all data in the hash table
     */
    public static ArrayList<Member> getAllMemberDetails(){
        ArrayList<Member> tempMemberList = new ArrayList<>();
        for(Integer key:memberKeyList){
        tempMemberList.add(memberHashtable.get(key));
        }
        return tempMemberList;
    }

    /**
     * Clears all stored data from the static class.
     *
     *
     */

    public static void purgeData(){
        memberKeyList.clear();
        memberHashtable.clear();
    }
}
