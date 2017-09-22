package com.davidcryer.services.football.results;

import com.davidcryer.domain.common.TwoTeamSport;
import com.davidcryer.services.baseentities.GeneratedIdEntity;
import com.davidcryer.services.football.club.FootballClub;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class FootballResult extends GeneratedIdEntity {
    @NotNull @Embedded
    private TwoTeamSport.Report report;
    @OneToMany(mappedBy = "result", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FootballCareerResult> players;
    @NotNull @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "id")
    private FootballClub club;

    public TwoTeamSport.Report getReport() {
        return report;
    }

    public void setReport(TwoTeamSport.Report report) {
        this.report = report;
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
