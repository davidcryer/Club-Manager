package com.davidcryer.services.football.results;

import com.davidcryer.services.football.club.FootballClub;
import com.davidcryer.services.football.member.FootballPlayer;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class FootballResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private Date date;
    @Min(0)
    @NotNull
    private Integer goalsA;
    @Min(0)
    @NotNull
    private Integer goalsB;
    @ManyToMany(mappedBy = "results", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<FootballPlayer> teamA;
    @ManyToMany(mappedBy = "results", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<FootballPlayer> teamB;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @NotNull
    private FootballClub club;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getGoalsA() {
        return goalsA;
    }

    public void setGoalsA(Integer goalsA) {
        this.goalsA = goalsA;
    }

    public Integer getGoalsB() {
        return goalsB;
    }

    public void setGoalsB(Integer goalsB) {
        this.goalsB = goalsB;
    }

    public List<FootballPlayer> getTeamA() {
        return teamA;
    }

    public void setTeamA(List<FootballPlayer> teamA) {
        this.teamA = teamA;
    }

    public List<FootballPlayer> getTeamB() {
        return teamB;
    }

    public void setTeamB(List<FootballPlayer> teamB) {
        this.teamB = teamB;
    }

    public FootballClub getClub() {
        return club;
    }

    public void setClub(FootballClub club) {
        this.club = club;
    }
}
