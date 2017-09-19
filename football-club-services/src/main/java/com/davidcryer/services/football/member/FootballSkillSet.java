package com.davidcryer.services.football.member;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Embeddable;

@Embeddable
public class FootballSkillSet {
    @Range(min = 0, max = 10)
    private short speed;
    @Range(min = 0, max = 10)
    private short skill;
    @Range(min = 0, max = 10)
    private short creativity;
    @Range(min = 0, max = 10)
    private short holdUp;
    @Range(min = 0, max = 10)
    private short shooting;
    @Range(min = 0, max = 10)
    private short defense;

    public short getSpeed() {
        return speed;
    }

    public void setSpeed(short speed) {
        this.speed = speed;
    }

    public short getSkill() {
        return skill;
    }

    public void setSkill(short skill) {
        this.skill = skill;
    }

    public short getCreativity() {
        return creativity;
    }

    public void setCreativity(short creativity) {
        this.creativity = creativity;
    }

    public short getHoldUp() {
        return holdUp;
    }

    public void setHoldUp(short holdUp) {
        this.holdUp = holdUp;
    }

    public short getShooting() {
        return shooting;
    }

    public void setShooting(short shooting) {
        this.shooting = shooting;
    }

    public short getDefense() {
        return defense;
    }

    public void setDefense(short defense) {
        this.defense = defense;
    }
}
