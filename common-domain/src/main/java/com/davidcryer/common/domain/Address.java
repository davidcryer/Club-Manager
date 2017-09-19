package com.davidcryer.common.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String postCode;

    public Address(String postCode) {
        this.postCode = postCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
