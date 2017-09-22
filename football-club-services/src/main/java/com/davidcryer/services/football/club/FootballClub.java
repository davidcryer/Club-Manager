package com.davidcryer.services.football.club;

import com.davidcryer.services.baseentities.Club;
import com.davidcryer.services.football.career.FootballCareer;
import com.davidcryer.services.football.results.FootballResult;

import javax.persistence.*;
import java.util.List;

@Entity
public class FootballClub extends Club {
    public final static String COLUMN_ID = "clubId";
    public final static String REF_FOOTBALL_CAREERS = "players";
    @ManyToMany(fetch = FetchType.LAZY) @JoinColumn(name = COLUMN_ID)
    private List<FootballCareer> players;
    @OneToMany(mappedBy = FootballResult.REF_FOOTBALL_CLUB, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FootballResult> results;

    public List<FootballCareer> getPlayers() {
        return players;
    }

    public void setPlayers(List<FootballCareer> players) {
        this.players = players;
    }

    public List<FootballResult> getResults() {
        return results;
    }

    public void setResults(List<FootballResult> results) {
        this.results = results;
    }
}
