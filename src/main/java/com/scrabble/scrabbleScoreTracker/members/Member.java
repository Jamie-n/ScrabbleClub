package com.scrabble.scrabbleScoreTracker.members;

public class Member {

    int id;
    String firstName;
    String lastName;
    int matchesPlayed;
    int wins;
    int losses;

    public Member(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.matchesPlayed = 0;
        this.wins = 0;
        this.losses = 0;
    }

    public Member(int id, String firstName, String lastName, int matchesPlayed, int wins, int losses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.losses = losses;
    }


    public int getId() {
        return id;
    }

    public void setId(int memberID) {
        this.id = memberID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}


