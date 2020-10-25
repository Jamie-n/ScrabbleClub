package com.scrabble.scrabbleScoreTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ScrabbleScoreTrackerApplication {



    public static void main(String[] args) {
        SpringApplication.run(ScrabbleScoreTrackerApplication.class, args);
    }

}

