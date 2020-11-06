package com.scrabble.scrabbleScoreTracker.database;

import com.scrabble.scrabbleScoreTracker.members.Member;
import com.scrabble.scrabbleScoreTracker.members.MemberStorage;
import org.hsqldb.Database;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.PostConstruct;
import java.sql.*;


/**
 * The service that pulls and user data from the database
 *
 * @author Jamie Neighbours
 * @version October 2020
 */


public class MemberDataServiceRetrieve {

    /**
     * Pulls all member data from database
     *
     *
     * @throws SQLException if connection cannot be established or data cannot be retrieved
     */

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



    }

    /**
     * Finds a single member from the database
     *
     * @param name - The first or last name of the member to be queried
     * @return - boolean based on the success of the query, automatically populates a static class
     */


    public static Boolean findMembers(String name) {

        try(Connection connection = DriverManager.getConnection(DatabaseConn.DATABASE_CONN)){
            ResultSet resultSet = DatabaseConn.retrieveData("SELECT m.id, m.first_name, m.last_name, m.phone_number,iif(isnull(wins.no_wins),0,wins.no_wins) as wins ,iif(isnull(losses.no_losses),0,losses.no_losses) as losses from (members m left join (select w.winner_id, count(1) as no_wins  from matches w group by w.winner_id) wins on m.id = wins.winner_id) left join (select l.looser_id, count(1) as no_losses from matches l group by l.looser_id) losses " +
                    "on m.id =losses.[looser_id] WHERE M.FIRST_NAME =\""+name+"\" OR m.last_name =\""+name+"\";");

            if(resultSet != null) {
                parseData(resultSet);
        }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Parses the data from the query and populates a static class.
     *
     * @param resultSet - The member data to be parsed
     * @throws SQLException - If no data is retrieved
     */


    private static void parseData(ResultSet resultSet) throws SQLException {
        MemberStorage.purgeData();
        while (resultSet.next()) {//Creates a list of members from the database
            MemberStorage.addMember(resultSet.getInt("id"), new Member(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("phone_number"),
                    resultSet.getInt("wins") + resultSet.getInt("losses"),
                    resultSet.getInt("wins"),
                    resultSet.getInt("losses")));
        }
    }


}
