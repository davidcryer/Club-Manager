package com.davidcryer.services.football.club;

import com.davidcryer.services.Club;
import com.davidcryer.services.football.member.FootballPlayer;
import com.davidcryer.services.football.results.FootballResult;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class FootballClub extends Club {
    @OneToMany(mappedBy = "club", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<FootballPlayer> players;
    @OneToMany(mappedBy = "club", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<FootballResult> results;

    public List<FootballPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<FootballPlayer> players) {
        this.players = players;
    }

    public List<FootballResult> getResults() {
        return results;
    }

    public void setResults(List<FootballResult> results) {
        this.results = results;
    }
}
