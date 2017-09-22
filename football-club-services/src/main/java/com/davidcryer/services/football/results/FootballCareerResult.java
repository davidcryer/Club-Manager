package com.davidcryer.services.football.results;

import com.davidcryer.domain.common.TwoTeamSport;
import com.davidcryer.services.football.career.FootballCareer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class FootballCareerResult {
    public final static String COLUMN_ID = "careerResultId";
    public final static String REF_FOOTBALL_RESULT = "result";
    public final static String REF_FOOTBALL_CAREER = "player";
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = COLUMN_ID)
    private long id;
    @NotNull @Enumerated(EnumType.STRING)
    private TwoTeamSport.Team team;
    @NotNull @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = FootballResult.COLUMN_ID)
    private FootballResult result;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = FootballCareer.COLUMN_ID)
    private FootballCareer player;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TwoTeamSport.Team getTeam() {
        return team;
    }

    public void setTeam(TwoTeamSport.Team team) {
        this.team = team;
    }

    public FootballResult getResult() {
        return result;
    }

    public void setResult(FootballResult result) {
        this.result = result;
    }

    public FootballCareer getPlayer() {
        return player;
    }

    public void setPlayer(FootballCareer player) {
        this.player = player;
    }
}
