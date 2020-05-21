package com.example.volleyball;

class Round {
    int n;
    int time;
    boolean team1;
    boolean team2;

    Round(int n, int ts, boolean team1, boolean team2) {
        this.n = n;
        this.time = ts;
        this.team1 = team1;
        this.team2 = team2;
    }
}
