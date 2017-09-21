package com.davidcryer.services.football.career;

import com.davidcryer.services.baseentities.IdEntity;
import com.davidcryer.services.football.club.FootballClub;
import com.davidcryer.services.football.results.FootballCareerResult;
import com.davidcryer.services.member.Member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class FootballCareer extends IdEntity {
    @NotNull @Embedded
    private FootballSkillSet skillSet;
    @NotNull @MapsId @OneToOne
    private Member member;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<FootballClub> clubs;
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FootballCareerResult> results;

    public FootballSkillSet getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(FootballSkillSet skillSet) {
        this.skillSet = skillSet;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<FootballClub> getClubs() {
        return clubs;
    }

    public void setClubs(List<FootballClub> clubs) {
        this.clubs = clubs;
    }

    public List<FootballCareerResult> getResults() {
        return results;
    }

    public void setResults(List<FootballCareerResult> results) {
        this.results = results;
    }
}
