package com.davidcryer.member.domain;

import com.davidcryer.common.domain.InvalidArgsException;
import org.junit.Assert;
import org.junit.Test;

public class MemberTests {

    @Test
    public void newInstance() {
        final Member member = Member.newInstance("Cherline", null, "outlaw@country.com");
        Assert.assertEquals(member.getFirstName(), "Cherline");
        Assert.assertEquals(member.getLastName(), null);
        Assert.assertEquals(member.getEmailAddress(), "outlaw@country.com");
    }

    @Test(expected = InvalidArgsException.class)
    public void newInstanceWithNullFirstName() {
        Member.newInstance(null, null, "outlaw@country.com");
    }

    @Test(expected = InvalidArgsException.class)
    public void newInstanceWithEmptyFirstName() {
        Member.newInstance("", null, "outlaw@country.com");
    }

    @Test(expected = InvalidArgsException.class)
    public void newInstanceWithNullEmailAddress() {
        Member.newInstance("Cherline", null, null);
    }

    @Test(expected = InvalidArgsException.class)
    public void newInstanceWithEmptyEmailAddress() {
        Member.newInstance("Cherline", null, "");
    }
}
