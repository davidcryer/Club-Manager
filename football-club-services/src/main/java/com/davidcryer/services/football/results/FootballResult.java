package com.davidcryer.services.football.results;

import com.davidcryer.domain.common.TwoTeamSport;
import com.davidcryer.services.baseentities.AutoIdEntity;
import com.davidcryer.services.football.club.FootballClub;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class FootballResult extends AutoIdEntity {
    @NotNull
    private Date date;
    @NotNull
    @Embedded
    private TwoTeamSport.Result result;
    @OneToMany(mappedBy = "result", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FootballCareerResult> players;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @NotNull
    private FootballClub club;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TwoTeamSport.Result getResult() {
        return result;
    }

    public void setResult(TwoTeamSport.Result result) {
        this.result = result;
    }

    public List<FootballCareerResult> getPlayers() {
        return players;
    }

    public void setPlayers(List<FootballCareerResult> players) {
        this.players = players;
    }

    public FootballClub getClub() {
        return club;
    }

    public void setClub(FootballClub club) {
        this.club = club;
    }
}
