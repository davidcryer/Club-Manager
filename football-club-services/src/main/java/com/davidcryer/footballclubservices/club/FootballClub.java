package com.davidcryer.footballclubservices.club;

import com.davidcryer.common.domain.Club;
import com.davidcryer.footballclubservices.member.FootballPlayer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class FootballClub extends Club {
    @OneToMany(mappedBy = "club", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FootballPlayer> players;

    public List<FootballPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<FootballPlayer> players) {
        this.players = players;
    }
}
