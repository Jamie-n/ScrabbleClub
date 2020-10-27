package com.scrabble.scrabbleScoreTracker.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConn {

    static final String DATABASE_CONN = "jdbc:ucanaccess://src/main/resources/testData/scrabbleClubTestData.accdb";

    /**
     * Retrieves data from a database
     *
     * @param query The sql query to be executed
     * @return a result set to be parsed into meaningful data
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
}
