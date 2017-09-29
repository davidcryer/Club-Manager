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
        } catch (InvalidArgsException ite) {
            Assert.assertTrue(ite.getMessage().contains("Failure message"));
            throw ite;
        }
    }

    @Test(expected = InvalidArgsException.class)
    public void checkFailureGivenSuccessfulCheckThenFailedCheck() {
        try {
            argsChecker
                    .addCheck(() -> true, "CheckResult 1 failed")
                    .addCheck(() -> false, "CheckResult 2 failed")
                    .execute();
        } catch (InvalidArgsException ite) {
            Assert.assertFalse(ite.getMessage().contains("CheckResult 1 failed"));
            Assert.assertTrue(ite.getMessage().contains("CheckResult 2 failed"));
            throw ite;
        }
    }

    @Test(expected = InvalidArgsException.class)
    public void checkFailureGivenFailedCheckThenSuccessfulCheck() {
        try {
            argsChecker
                    .addCheck(() -> false, "CheckResult 1 failed")
                    .addCheck(() -> true, "CheckResult 2 failed")
                    .execute();
        } catch (InvalidArgsException ite) {
            Assert.assertTrue(ite.getMessage().contains("CheckResult 1 failed"));
            Assert.assertFalse(ite.getMessage().contains("CheckResult 2 failed"));
            throw ite;
        }
    }

    @Test(expected = InvalidArgsException.class)
    public void checkFailureContainsAllFailedCheckMessages() {
        try {
            argsChecker
                    .addCheck(() -> false, "CheckResult 1 failed")
                    .addCheck(() -> false, "CheckResult 2 failed")
                    .execute();
        } catch (InvalidArgsException ite) {
            Assert.assertTrue(ite.getMessage().contains("CheckResult 1 failed"));
            Assert.assertTrue(ite.getMessage().contains("CheckResult 2 failed"));
            throw ite;
        }
    }
}
