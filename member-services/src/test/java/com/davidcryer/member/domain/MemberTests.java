package com.davidcryer.member.domain;

import com.davidcryer.common.domain.IllegalArgsException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MemberTests {

    @Test
    public void newInstance() {
        final Member member = Member.newInstance("Cherline", null, "outlaw@country.com");
        Assert.assertEquals(member.getFirstName(), "Cherline");
        Assert.assertEquals(member.getLastName(), null);
        Assert.assertEquals(member.getEmailAddress(), "outlaw@country.com");
    }

    @Test(expected = IllegalArgsException.class)
    public void newInstanceWithNullFirstName() {
        Member.newInstance(null, null, "outlaw@country.com");
    }

    @Test(expected = IllegalArgsException.class)
    public void newInstanceWithEmptyFirstName() {
        Member.newInstance("", null, "outlaw@country.com");
    }

    @Test(expected = IllegalArgsException.class)
    public void newInstanceWithNullEmailAddress() {
        Member.newInstance("Cherline", null, null);
    }

    @Test(expected = IllegalArgsException.class)
    public void newInstanceWithEmptyEmailAddress() {
        Member.newInstance("Cherline", null, "");
    }

    public static class WriterTests {
        private Member member;

        @Before
        public void setup() {
            member = Member.newInstance("Cherline", null, "outlaw@country.com");
        }

        @Test
        public void changeFirstName() {
            member.writer().firstName("Cheryl").commit();
            Assert.assertEquals(member.getFirstName(), "Cheryl");
        }

        @Test(expected = IllegalArgsException.class)
        public void illegalFirstName() {
            member.writer().firstName("").commit();
        }
    }
}
