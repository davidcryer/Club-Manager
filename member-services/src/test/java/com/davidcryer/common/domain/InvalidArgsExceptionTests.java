package com.davidcryer.common.domain;

import org.junit.Assert;
import org.junit.Test;

public class InvalidArgsExceptionTests {

    @Test
    public void checkMessageFormat() {
        final InvalidArgsException iae = new InvalidArgsException(new String[] {"Message 1", "Message 2"});
        Assert.assertEquals(iae.getMessage(), "Message 1\nMessage 2");
    }
}
