package com.davidcryer.domain.common;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

public class TwoTeamSport extends Sport {
    public enum Team {
        A, B
    }

    @Embeddable
    public static class Report extends Sport.Report {
        @NotNull
        private int goalsTeamA;
        @NotNull
        private int goalsTeamB;
        @NotNull
        private int sizeTeamA;
        @NotNull
        private int sizeTeamB;

        public int getGoalsTeamA() {
            return goalsTeamA;
        }

        public void setGoalsTeamA(int goalsTeamA) {
            this.goalsTeamA = goalsTeamA;
        }

        public int getGoalsTeamB() {
            return goalsTeamB;
        }

        public void setGoalsTeamB(int goalsTeamB) {
            this.goalsTeamB = goalsTeamB;
        }

        public int getSizeTeamA() {
            return sizeTeamA;
        }

        public void setSizeTeamA(int sizeTeamA) {
            this.sizeTeamA = sizeTeamA;
        }

        public int getSizeTeamB() {
            return sizeTeamB;
        }

        public void setSizeTeamB(int sizeTeamB) {
            this.sizeTeamB = sizeTeamB;
        }
    }
}
