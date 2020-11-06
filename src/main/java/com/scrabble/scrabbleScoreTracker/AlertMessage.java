package com.scrabble.scrabbleScoreTracker;

/**
 * Alert class to be presented to the user
 * @author Jamie Neighbours
 * @version November 2020
 *
 *
 */

public class AlertMessage {



    private String alert;

    public AlertMessage(String alert) {
        this.alert = alert;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }
}
