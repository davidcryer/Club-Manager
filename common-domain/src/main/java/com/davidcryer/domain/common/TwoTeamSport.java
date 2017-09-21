package com.davidcryer.domain.common;

import javax.persistence.Embeddable;

public class TwoTeamSport extends Sport {
    public enum Team {
        A, B
    }

    @Embeddable
    public static class Result {
        private int goalsA;
        private int goalsB;

        public int getGoalsA() {
            return goalsA;
        }

        public void setGoalsA(int goalsA) {
            this.goalsA = goalsA;
        }

        public int getGoalsB() {
            return goalsB;
        }

        public void setGoalsB(int goalsB) {
            this.goalsB = goalsB;
        }
    }
}
