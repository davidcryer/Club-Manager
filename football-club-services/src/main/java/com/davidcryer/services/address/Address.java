package com.davidcryer.services.address;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
    public final static String COLUMN_ID = "addressId";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = COLUMN_ID)
    private long id;
    @NotNull
    private String line1;
    private String line2;
    @NotNull
    private String city;
    private String county;
    @NotNull
    private String postCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
