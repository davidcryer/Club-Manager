package com.davidcryer.services.member;

import com.davidcryer.services.address.Address;
import com.davidcryer.services.football.career.FootballCareer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Member {
    public final static String COLUMN_ID = "memberId";
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = COLUMN_ID)
    private long id;
    @NotNull
    private String firstName;
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = Address.COLUMN_ID)
    private Address address;
    @OneToOne(mappedBy = FootballCareer.REF_MEMBER, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private FootballCareer footballCareer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public FootballCareer getFootballCareer() {
        return footballCareer;
    }

    public void setFootballCareer(FootballCareer footballCareer) {
        this.footballCareer = footballCareer;
    }
}
