package com.davidcryer.common.domain;

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

    @Test
    public void equalStringsBothNull() {
        Assert.assertTrue(StringUtils.equal(null, null));
    }

    @Test
    public void equalStringsNonNull() {
        Assert.assertTrue(StringUtils.equal("", ""));
    }

    @Test
    public void unequalStringsOneNull() {
        Assert.assertFalse(StringUtils.equal(null, ""));
    }
}
