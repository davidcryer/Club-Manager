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
    public void checkSuccess() {
        argsChecker.addCheck(() -> true, "").execute();
    }

    @Test(expected = InvalidArgsException.class)
    public void checkFailure() {
        try {
            argsChecker.addCheck(() -> false, "Failure message").execute();
        } catch (InvalidArgsException iae) {
            Assert.assertTrue(iae.getMessage().contains("Failure message"));
            throw iae;
        }
    }

    @Test(expected = InvalidArgsException.class)
    public void checkFailureGivenSuccessfulCheckThenFailedCheck() {
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
    public void checkFailureGivenFailedCheckThenSuccessfulCheck() {
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
    public void checkFailureContainsAllFailedCheckMessages() {
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
