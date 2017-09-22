package com.davidcryer.services.football.career;

import com.davidcryer.services.football.club.FootballClub;
import com.davidcryer.services.football.results.FootballCareerResult;
import com.davidcryer.services.member.Member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class FootballCareer {
    public final static String COLUMN_ID = "careerId";
    public final static String REF_MEMBER = "member";
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = COLUMN_ID)
    private long id;
    @NotNull @Embedded
    private FootballSkillSet skillSet;
    @NotNull @MapsId @OneToOne(fetch = FetchType.LAZY)
    private Member member;
    @ManyToMany(mappedBy = FootballClub.REF_FOOTBALL_CAREERS, fetch = FetchType.LAZY)
    private List<FootballClub> clubs;
    @OneToMany(mappedBy = FootballCareerResult.REF_FOOTBALL_CAREER, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FootballCareerResult> results;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
