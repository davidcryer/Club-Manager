package com.davidcryer.services.member;

import com.davidcryer.services.address.Address;
import com.davidcryer.services.baseentities.AutoIdEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Member extends AutoIdEntity {
    @NotNull
    private String firstName;
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

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
}
