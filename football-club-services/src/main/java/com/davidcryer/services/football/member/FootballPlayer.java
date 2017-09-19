package com.davidcryer.services.football.member;

import com.davidcryer.services.baseentities.Person;
import com.davidcryer.services.football.club.FootballClub;
import com.davidcryer.services.football.results.FootballResult;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class FootballPlayer extends Person {
    @Embedded
    private FootballSkillSet skillSet;
    @ManyToMany(mappedBy = "teamA", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<FootballResult> results;
    @ManyToMany(mappedBy = "players", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<FootballClub> clubs;

    public FootballSkillSet getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(FootballSkillSet skillSet) {
        this.skillSet = skillSet;
    }

    public List<FootballResult> getResults() {
        return results;
    }

    public void setResults(List<FootballResult> results) {
        this.results = results;
    }

    @JsonIgnore
    public List<FootballClub> getClubs() {
        return clubs;
    }

    public void setClubs(List<FootballClub> clubs) {
        this.clubs = clubs;
    }
}
