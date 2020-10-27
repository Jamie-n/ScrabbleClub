package com.scrabble.scrabbleScoreTracker.database;

import org.springframework.jdbc.object.SqlQuery;

import javax.annotation.PostConstruct;
import java.sql.*;

/**
 * A class to connect to the test data database
 *
 * @author Jamie Neighbours
 * @version October 2020
 */

public class MemberDataServicePush {



    /**
     * Pushes new data to the database when a user is created
     *
     * @param firstName First name of the member
     * @param lastName Last name of the member
     * @param phoneNumber Phone number of the member
     */

@PostConstruct
    public static void pushData(String firstName, String lastName, String phoneNumber) {
        try (Connection connection = DriverManager.getConnection(DatabaseConn.DATABASE_CONN)) {
            String sql = "INSERT INTO Members(First_Name, Last_Name, Phone_Number) values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,firstName);
            statement.setString(2,lastName);
            statement.setString(3,phoneNumber);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
