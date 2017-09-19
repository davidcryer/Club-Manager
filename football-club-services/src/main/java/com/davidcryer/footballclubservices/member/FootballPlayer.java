package com.davidcryer.footballclubservices.member;

import com.davidcryer.common.domain.Person;
import com.davidcryer.footballclubservices.club.FootballClub;
import com.davidcryer.footballclubservices.common.FootballResults;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class FootballPlayer extends Person {
    @Embedded
    private FootballSkillSet skillSet;
    @Embedded
    private FootballResults results;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private FootballClub club;

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
