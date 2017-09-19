package com.davidcryer.footballclubservices.member;

import com.davidcryer.common.domain.Person;
import com.davidcryer.footballclubservices.club.FootballClub;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class FootballPlayer extends Person {
    @Embedded
    private FootballSkillSet skillSet;
    @Embedded
    private FootballResults results;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private FootballClub club;

    FootballPlayer() {
        super();
    }

    public FootballPlayer(String firstName, String lastName, FootballSkillSet skillSet, FootballResults results, FootballClub club) {
        super(firstName, lastName);
        this.skillSet = skillSet;
        this.results = results;
        this.club = club;
    }

    public FootballSkillSet getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(FootballSkillSet skillSet) {
        this.skillSet = skillSet;
    }

    public FootballResults getResults() {
        return results;
    }

    public void setResults(FootballResults results) {
        this.results = results;
    }

    @JsonIgnore
    public FootballClub getClub() {
        return club;
    }

    public void setClub(FootballClub club) {
        this.club = club;
    }
}
