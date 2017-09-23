package com.davidcryer.common.domain;

public class StringUtils {

    public static boolean isNullOrEmpty(final String s) {
        return s == null || s.isEmpty();
    }

    public static boolean notNullOrEmpty(final String s) {
        return !isNullOrEmpty(s);
    }

    public static boolean equal(final String s1, final String s2) {
        return s1 == null ? s2 == null : s1.equals(s2);
    }
}
