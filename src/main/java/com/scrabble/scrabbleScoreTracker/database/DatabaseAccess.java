package com.scrabble.scrabbleScoreTracker.database;

import org.springframework.jdbc.object.SqlQuery;

import java.sql.*;

/**
 * A class to connect to the test data database
 *
 * @author Jamie Neighbours
 * @version October 2020
 */

public class DatabaseAccess {

    static final String DATABASE_CONN = "jdbc:ucanaccess://src/main/resources/testData/scrabbleClubTestData.accdb";

    /**
     * Retrieves data from a database
     *
     * @param query
     * @return
     */
    public static ResultSet retrieveData(String query) {
        try (Connection connection = DriverManager.getConnection(DATABASE_CONN)) {
            return connection.createStatement().executeQuery(query);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ;
        return null;
    }


    public static void pushData(Integer id, String firstName, String lastName, String phoneNumber) {
        try (Connection connection = DriverManager.getConnection(DATABASE_CONN)) {
            String sql = "INSERT INTO Members values (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.setString(2,firstName);
            statement.setString(3,lastName);
            statement.setString(4,phoneNumber);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ;
    }
}
