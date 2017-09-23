package com.davidcryer.common.domain;

public class StringUtils {

    public static boolean isNullOrEmpty(final String s) {
        return s == null || s.isEmpty();
    }

    public static boolean notNullOrEmpty(final String s) {
        return !isNullOrEmpty(s);
    }
}
