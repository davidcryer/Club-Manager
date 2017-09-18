package main.java.com.davidcryer.common.domain;

@Embeddable
public class Address {
    private String postCode;

    Address() {

    }

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
