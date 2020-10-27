package com.scrabble.scrabbleScoreTracker.database;

import com.scrabble.scrabbleScoreTracker.members.Member;
import com.scrabble.scrabbleScoreTracker.members.MemberStorage;
import org.hsqldb.Database;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * The service that pulls and user data from the database
 *
 * @author Jamie Neighbours
 * @version October 2020
 *
 *
 */


public class MemberDataServiceRetrieve {

    @PostConstruct
    public static void getAllMemberDataFromDb() throws SQLException {
        ResultSet resultSet = DatabaseConn.retrieveData("SELECT m.id, m.first_name, m.last_name, m.phone_number, IIf(IsNull(wins.no_wins),0,wins.no_wins) AS wins, IIf(IsNull(losses.no_losses),0,losses.no_losses) AS losses\n" +
                "FROM (members AS m LEFT JOIN (select w.winner_id, count(1) as no_wins\n" +
                "\n" +
                "               from matches w\n" +
                "\n" +
                "               group by w.winner_id)  AS wins ON m.id = wins.winner_id) LEFT JOIN (select l.looser_id, count(1) as no_losses\n" +
                "\n" +
                "               from matches l\n" +
                "\n" +
                "               group by l.looser_id)  AS losses ON m.id = losses.[looser_id];\n" +
                "\n" +
                "\n");


        while (resultSet.next()) {//Creates a list of members from the database
            MemberStorage.addMember(resultSet.getInt("id"), new Member(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("phone_number"),
                    resultSet.getInt("wins")+resultSet.getInt("losses"),
                    resultSet.getInt("wins"),
                    resultSet.getInt("losses")));
        }
    }


    public static Integer findKey(){
        try{
            ResultSet resultSet = DatabaseConn.retrieveData("")
        }catch (Exception e){

        }

        return null;
        }




}