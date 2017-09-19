package com.davidcryer.footballclubservices.member;

import javax.persistence.Embeddable;

@Embeddable
public class FootballSkillSet {
    private int speed;
    private int skill;
    private int creativity;
    private int holdUp;
    private int shooting;
    private int defense;

    FootballSkillSet() {}

    public FootballSkillSet(int speed, int skill, int creativity, int holdUp, int shooting, int defense) {
        this.speed = speed;
        this.skill = skill;
        this.creativity = creativity;
        this.holdUp = holdUp;
        this.shooting = shooting;
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getCreativity() {
        return creativity;
    }

    public void setCreativity(int creativity) {
        this.creativity = creativity;
    }

    public int getHoldUp() {
        return holdUp;
    }

    public void setHoldUp(int holdUp) {
        this.holdUp = holdUp;
    }

    public int getShooting() {
        return shooting;
    }

    public void setShooting(int shooting) {
        this.shooting = shooting;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
