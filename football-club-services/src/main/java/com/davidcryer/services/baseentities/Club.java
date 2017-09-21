package com.davidcryer.services.baseentities;

import com.davidcryer.services.address.Address;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Club extends GeneratedIdEntity {
    @NotNull
    private String name;
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Address address;

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
