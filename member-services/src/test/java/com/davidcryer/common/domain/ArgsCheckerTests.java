package com.davidcryer.common.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArgsCheckerTests {
    private ArgsChecker argsChecker;

    @Before
    public void setup() {
        argsChecker = ArgsChecker.newInstance();
    }

    @Test
    public void success() {
        argsChecker.addCheck(() -> true, "").execute();
    }

    @Test(expected = InvalidArgsException.class)
    public void failure() {
        try {
            argsChecker.addCheck(() -> false, "Failure message").execute();
        } catch (InvalidArgsException iae) {
            Assert.assertTrue(iae.getMessage().contains("Failure message"));
            throw iae;
        }
    }

    @Test(expected = InvalidArgsException.class)
    public void failureGivenSuccessfulCheckThenFailedCheck() {
        try {
            argsChecker
                    .addCheck(() -> true, "CheckResult 1 failed")
                    .addCheck(() -> false, "CheckResult 2 failed")
                    .execute();
        } catch (InvalidArgsException iae) {
            Assert.assertFalse(iae.getMessage().contains("CheckResult 1 failed"));
            Assert.assertTrue(iae.getMessage().contains("CheckResult 2 failed"));
            throw iae;
        }
    }

    @Test(expected = InvalidArgsException.class)
    public void failureGivenFailedCheckThenSuccessfulCheck() {
        try {
            argsChecker
                    .addCheck(() -> false, "CheckResult 1 failed")
                    .addCheck(() -> true, "CheckResult 2 failed")
                    .execute();
        } catch (InvalidArgsException iae) {
            Assert.assertTrue(iae.getMessage().contains("CheckResult 1 failed"));
            Assert.assertFalse(iae.getMessage().contains("CheckResult 2 failed"));
            throw iae;
        }
    }

    @Test(expected = InvalidArgsException.class)
    public void failureExceptionContainsAllFailedCheckMessages() {
        try {
            argsChecker
                    .addCheck(() -> false, "CheckResult 1 failed")
                    .addCheck(() -> false, "CheckResult 2 failed")
                    .execute();
        } catch (InvalidArgsException iae) {
            Assert.assertTrue(iae.getMessage().contains("CheckResult 1 failed"));
            Assert.assertTrue(iae.getMessage().contains("CheckResult 2 failed"));
            throw iae;
        }
    }
}
