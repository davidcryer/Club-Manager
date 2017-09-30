package com.davidcryer.common;

import org.springframework.util.StringUtils;

public class IllegalArgsException extends RuntimeException {
    private final static String NEW_LINE = "\n";

    IllegalArgsException(String[] messages) {
        super(concatenate(messages));
    }

    private static String concatenate(String[] messages) {
        return StringUtils.arrayToDelimitedString(messages, NEW_LINE);
    }
}
