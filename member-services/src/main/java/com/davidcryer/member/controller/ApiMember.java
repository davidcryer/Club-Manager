package com.davidcryer.member.controller;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public abstract class ApiMember {
    private String firstName;
    private String lastName;
    private String emailAddress;

    ApiMember() {}

    ApiMember(String firstName, String lastName, String emailAddress) {
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
        return filledHashBuilder(new HashCodeBuilder()).toHashCode();
    }

    HashCodeBuilder filledHashBuilder(final HashCodeBuilder builder) {
        return builder
                .append(getFirstName())
                .append(getLastName())
                .append(getEmailAddress());
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || equalsSeparate(obj);
    }

    boolean equalsSeparate(final Object obj) {
        return obj instanceof ApiMember && equalsSeparate((ApiMember) obj);
    }

    private boolean equalsSeparate(final ApiMember member) {
        return filledEqualsBuilder(member).isEquals();
    }

    EqualsBuilder filledEqualsBuilder(final ApiMember member) {
        return new EqualsBuilder()
                .append(getFirstName(), member.getFirstName())
                .append(getLastName(), member.getLastName())
                .append(getEmailAddress(), member.getEmailAddress());
    }

    public static class Request extends ApiMember {

        public Request() {}

        public Request(String firstName, String lastName, String emailAddress) {
            super(firstName, lastName, emailAddress);
        }

        @Override
        boolean equalsSeparate(final Object obj) {
            return obj instanceof Request && super.equalsSeparate((Request) obj);
        }
    }

    public static class Response extends ApiMember {
        private long id;

        public Response() {}

        public Response(long id, String firstName, String lastName, String emailAddress) {
            super(firstName, lastName, emailAddress);
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        @Override
        HashCodeBuilder filledHashBuilder(HashCodeBuilder builder) {
            return super.filledHashBuilder(builder).append(id);
        }

        @Override
        boolean equalsSeparate(final Object obj) {
            return obj instanceof Response && equalsSeparate((Response) obj);
        }

        private boolean equalsSeparate(final Response member) {
            return filledEqualsBuilder(member).isEquals();
        }

        private EqualsBuilder filledEqualsBuilder(final Response member) {
            return super.filledEqualsBuilder(member).append(id, member.id);
        }
    }
}
