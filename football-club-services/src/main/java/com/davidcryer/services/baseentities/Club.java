package com.davidcryer.services.baseentities;

import com.davidcryer.services.address.Address;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Club {
    public final static String COLUMN_ID = "clubId";
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = COLUMN_ID)
    private long id;
    @NotNull
    private String name;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = Address.COLUMN_ID)
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
