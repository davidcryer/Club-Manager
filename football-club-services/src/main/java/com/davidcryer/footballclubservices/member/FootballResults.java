package com.davidcryer.footballclubservices.member;

import javax.persistence.Embeddable;

@Embeddable
public class FootballResults {
    private int wins;
    private int losses;
    private int draws;

    FootballResults() {}

    public FootballResults(int wins, int losses, int draws) {
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }
}
