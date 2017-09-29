package com.davidcryer.common;

import org.junit.Assert;
import org.junit.Test;

public class ArgsInspectorTests {

    @Test
    public void success() {
        ArgsInspector.inspect(ArgsInspector.check(() -> true, ""));
    }

    @Test(expected = IllegalArgsException.class)
    public void failure() {
        try {
            ArgsInspector.inspect(ArgsInspector.check(() -> false, "Failure message"));
        } catch (IllegalArgsException iae) {
            Assert.assertTrue(iae.getMessage().contains("Failure message"));
            throw iae;
        }
    }

    @Test(expected = IllegalArgsException.class)
    public void failureGivenSuccessfulCheckThenFailedCheck() {
        try {
            ArgsInspector.inspect(
                    ArgsInspector.check(() -> true, "CheckResult 1 failed"),
                    ArgsInspector.check(() -> false, "CheckResult 2 failed")
            );
        } catch (IllegalArgsException iae) {
            Assert.assertFalse(iae.getMessage().contains("CheckResult 1 failed"));
            Assert.assertTrue(iae.getMessage().contains("CheckResult 2 failed"));
            throw iae;
        }
    }
}
