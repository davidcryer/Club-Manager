package com.davidcryer.common;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTests {

    @Test
    public void stringIsNull() {
        Assert.assertTrue(StringUtils.isNullOrEmpty(null));
    }

    @Test
    public void stringIsEmpty() {
        Assert.assertTrue(StringUtils.isNullOrEmpty(""));
    }

    @Test
    public void stringNotEmpty() {
        Assert.assertTrue(StringUtils.notNullOrEmpty("String"));
    }
}
