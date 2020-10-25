package com.scrabble.scrabbleScoreTracker.database;

import org.springframework.jdbc.object.SqlQuery;

import java.sql.*;

/**
 * A class to connect to the test data database
 *
 * @author Jamie Neighbours
 * @version October 2020
 *
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


    try(Connection connection = DriverManager.getConnection(DATABASE_CONN)) {
        return connection.createStatement().executeQuery(query);

    } catch (SQLException ex) {
        ex.printStackTrace();
    } ;

    return null;

}
}
