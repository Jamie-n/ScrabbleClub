package com.scrabble.scrabbleScoreTracker.members;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import java.util.Date;


public class DatePicker {

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateChosen;


    public Date getDateChosen() {
        return dateChosen;
    }

    public void setDateChosen(Date dateChosen) {
        this.dateChosen = dateChosen;
    }

}
