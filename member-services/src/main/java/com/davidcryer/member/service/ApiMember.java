package com.davidcryer.member.service;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ApiMember {
    private String firstName;
    private String lastName;
    private String emailAddress;

    public ApiMember() {}

    public ApiMember(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(firstName)
                .append(lastName)
                .append(emailAddress)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || equalsSeparate(obj);
    }

    private boolean equalsSeparate(final Object obj) {
        return obj instanceof ApiMember && equalsSeparate((ApiMember) obj);
    }

    private boolean equalsSeparate(final ApiMember apiMember) {
        return new EqualsBuilder()
                .append(firstName, apiMember.firstName)
                .append(lastName, apiMember.lastName)
                .append(emailAddress, apiMember.emailAddress)
                .isEquals();
    }
}
