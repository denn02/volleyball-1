package com.example.volleyball;

public class GameInfo {
     String date;
     String firstTeam;
     String score;
     String secondTeam;
    GameInfo(String date,String firstTeam,String score,String secondTeam){
        this.date = date;
        this.firstTeam = firstTeam;
        this.score = score;
        this.secondTeam = secondTeam;
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
}
