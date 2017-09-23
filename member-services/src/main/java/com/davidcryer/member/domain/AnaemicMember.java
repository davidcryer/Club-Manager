package com.davidcryer.member.domain;

import javax.persistence.*;

@MappedSuperclass
@SuppressWarnings("unused")
class AnaemicMember {
    private final static String COLUMN_ID = "memberId";
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = COLUMN_ID)
    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    AnaemicMember() {}

    AnaemicMember(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String getEmailAddress() {
        return emailAddress;
    }

    void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
