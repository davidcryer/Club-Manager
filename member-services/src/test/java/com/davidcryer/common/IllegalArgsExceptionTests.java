package com.davidcryer.common;

import org.junit.Assert;
import org.junit.Test;

public class IllegalArgsExceptionTests {

    @Test
    public void messageFormat() {
        final IllegalArgsException iae = new IllegalArgsException(new String[] {"Message 1", "Message 2"});
        Assert.assertEquals(iae.getMessage(), "Message 1\nMessage 2");
    }
}
