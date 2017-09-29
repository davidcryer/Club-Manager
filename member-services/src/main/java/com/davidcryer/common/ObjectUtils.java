package com.davidcryer.common;

public class ObjectUtils {

    private ObjectUtils() {}

    public static boolean equal(final Object s1, final Object s2) {
        return s1 == null ? s2 == null : s1.equals(s2);
    }
}
