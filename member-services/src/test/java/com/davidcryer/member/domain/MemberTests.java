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

        @Test
        public void changeLastName() {
            member.writer().lastName("Tunt").commit();
            Assert.assertEquals(member.getLastName(), "Tunt");
        }

        @Test
        public void changeEmailAddress() {
            member.writer().emailAddress("tunt@fortunes.com").commit();
            Assert.assertEquals(member.getEmailAddress(), "tunt@fortunes.com");
        }

        @Test(expected = IllegalArgsException.class)
        public void illegalEmailAddress() {
            member.writer().emailAddress("").commit();
        }

        @Test
        public void illegalArgsExceptionContainsAllFailureMessages() {
            try {
                member.writer().firstName("").emailAddress("").commit();
                assert false;
            } catch (IllegalArgsException iae) {
                Assert.assertTrue(iae.getMessage().contains(Member.INVALID_FIELD_MESSAGE_FIRST_NAME));
                Assert.assertTrue(iae.getMessage().contains(Member.INVALID_FIELD_MESSAGE_EMAIL_ADDRESS));
            }
        }
    }
}
