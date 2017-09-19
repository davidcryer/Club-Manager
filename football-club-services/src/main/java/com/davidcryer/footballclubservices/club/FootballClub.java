package com.davidcryer.footballclubservices.club;

import com.davidcryer.common.domain.Address;
import com.davidcryer.common.domain.Club;
import com.davidcryer.footballclubservices.member.FootballPlayer;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class FootballClub extends Club {
    @OneToMany(mappedBy = "club", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FootballPlayer> players;

    FootballClub() {
        super();
    }

    public FootballClub(String name, Address address, List<FootballPlayer> players) {
        super(name, address);
        this.players = players;
    }

    public List<FootballPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<FootballPlayer> players) {
        this.players = players;
    }
}
