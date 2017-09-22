package com.davidcryer.services.football.results;

import com.davidcryer.domain.common.TwoTeamSport;
import com.davidcryer.services.football.club.FootballClub;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class FootballResult {
    public final static String COLUMN_ID = "resultId";
    public final static String REF_FOOTBALL_CLUB = "club";
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = COLUMN_ID)
    private long id;
    @NotNull @Embedded
    private TwoTeamSport.Report report;
    @OneToMany(mappedBy = FootballCareerResult.REF_FOOTBALL_RESULT, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FootballCareerResult> players;
    @NotNull @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = FootballClub.COLUMN_ID)
    private FootballClub club;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TwoTeamSport.Report getReport() {
        return report;
    }

    public void setReport(TwoTeamSport.Report report) {
        this.report = report;
    }

    public List<FootballCareerResult> getPlayers() {
        return players;
    }

    public void setPlayers(List<FootballCareerResult> players) {
        this.players = players;
    }

    public FootballClub getClub() {
        return club;
    }

    public void setClub(FootballClub club) {
        this.club = club;
    }
}
