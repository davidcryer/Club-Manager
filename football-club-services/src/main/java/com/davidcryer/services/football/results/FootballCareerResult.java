package com.davidcryer.services.football.results;

import com.davidcryer.domain.common.TwoTeamSport;
import com.davidcryer.services.baseentities.GeneratedIdEntity;
import com.davidcryer.services.football.career.FootballCareer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class FootballCareerResult extends GeneratedIdEntity {
    @NotNull @Enumerated(EnumType.STRING)
    private TwoTeamSport.Team team;
    @NotNull @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "id")
    private FootballResult result;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "id")
    private FootballCareer player;

    public TwoTeamSport.Team getTeam() {
        return team;
    }

    public void setTeam(TwoTeamSport.Team team) {
        this.team = team;
    }

    public FootballResult getResult() {
        return result;
    }

    public void setResult(FootballResult result) {
        this.result = result;
    }

    public FootballCareer getPlayer() {
        return player;
    }

    public void setPlayer(FootballCareer player) {
        this.player = player;
    }
}
