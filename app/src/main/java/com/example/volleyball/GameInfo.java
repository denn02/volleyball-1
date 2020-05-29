package com.example.volleyball;

public class GameInfo {
     String date;
     String firstTeam;
     String score;
     String secondTeam;
     int leftScore;
     int rightScore;
     long timeMillis;


    GameInfo(String date,String firstTeam,String score,String secondTeam){
        this.date = date;
        this.firstTeam = firstTeam;
        this.score = score;
        this.secondTeam = secondTeam;
    }

    public GameInfo(String team1Name, String team2Name) {
        this.firstTeam = team1Name;
        this.secondTeam = team2Name;
    }

    public String getDate() {
        return date;
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public String getScore() {
        return score;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setTime(long timeMillis) {
        this.timeMillis = timeMillis;
    }
}
