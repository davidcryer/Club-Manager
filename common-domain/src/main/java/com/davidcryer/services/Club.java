package com.davidcryer.services;

import com.davidcryer.services.address.Address;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String name;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
