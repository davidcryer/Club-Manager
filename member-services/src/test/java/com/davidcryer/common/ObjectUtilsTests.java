package com.davidcryer.common;

import org.junit.Assert;
import org.junit.Test;

public class ObjectUtilsTests {

    @Test
    public void equalObjectsBothNull() {
        Assert.assertTrue(ObjectUtils.equal(null, null));
    }

    @Test
    public void equalObjectsNonNull() {
        Assert.assertTrue(ObjectUtils.equal("", ""));
    }

    @Test
    public void unequalObjectsOneNull() {
        Assert.assertFalse(ObjectUtils.equal(null, ""));
    }
}
