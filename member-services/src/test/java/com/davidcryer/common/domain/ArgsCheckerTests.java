package com.davidcryer.common.domain;

import org.junit.Assert;
import org.junit.Test;

public class ArgsCheckerTests {

    @Test
    public void success() {
        ArgsChecker.runChecks(new ArgsChecker.Check(() -> true, ""));
    }

    @Test(expected = IllegalArgsException.class)
    public void failure() {
        try {
            ArgsChecker.runChecks(new ArgsChecker.Check(() -> false, "Failure message"));
        } catch (IllegalArgsException iae) {
            Assert.assertTrue(iae.getMessage().contains("Failure message"));
            throw iae;
        }
    }

    @Test(expected = IllegalArgsException.class)
    public void failureGivenSuccessfulCheckThenFailedCheck() {
        try {
            ArgsChecker.runChecks(
                    new ArgsChecker.Check(() -> true, "Check 1 failed"),
                    new ArgsChecker.Check(() -> false, "Check 2 failed")
            );
        } catch (IllegalArgsException iae) {
            Assert.assertFalse(iae.getMessage().contains("Check 1 failed"));
            Assert.assertTrue(iae.getMessage().contains("Check 2 failed"));
            throw iae;
        }
    }

    @Test(expected = IllegalArgsException.class)
    public void failureGivenFailedCheckThenSuccessfulCheck() {
        try {
            ArgsChecker.runChecks(
                    new ArgsChecker.Check(() -> false, "Check 1 failed"),
                    new ArgsChecker.Check(() -> true, "Check 2 failed")
            );
        } catch (IllegalArgsException iae) {
            Assert.assertTrue(iae.getMessage().contains("Check 1 failed"));
            Assert.assertFalse(iae.getMessage().contains("Check 2 failed"));
            throw iae;
        }
    }

    @Test(expected = IllegalArgsException.class)
    public void failureExceptionContainsAllFailedCheckMessages() {
        try {
            ArgsChecker.runChecks(
                    new ArgsChecker.Check(() -> false, "Check 1 failed"),
                    new ArgsChecker.Check(() -> false, "Check 2 failed")
            );
        } catch (IllegalArgsException iae) {
            Assert.assertTrue(iae.getMessage().contains("Check 1 failed"));
            Assert.assertTrue(iae.getMessage().contains("Check 2 failed"));
            throw iae;
        }
    }
}
