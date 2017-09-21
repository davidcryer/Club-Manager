package com.davidcryer.services.football.career;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class FootballSkillSet {
    @NotNull @Range(min = 0, max = 10)
    private short speed;
    @NotNull @Range(min = 0, max = 10)
    private short ballControl;
    @NotNull @Range(min = 0, max = 10)
    private short creativity;
    @NotNull @Range(min = 0, max = 10)
    private short holdUp;
    @NotNull @Range(min = 0, max = 10)
    private short shooting;
    @NotNull @Range(min = 0, max = 10)
    private short defense;

    public short getSpeed() {
        return speed;
    }

    public void setSpeed(short speed) {
        this.speed = speed;
    }

    public short getBallControl() {
        return ballControl;
    }

    public void setBallControl(short ballControl) {
        this.ballControl = ballControl;
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
