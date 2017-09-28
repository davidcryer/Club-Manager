package com.davidcryer.common.domain;

import org.springframework.util.StringUtils;

public class InvalidArgsException extends RuntimeException {
    private final static String NEW_LINE = "\n";

    InvalidArgsException(String[] messages) {
        super(concatenate(messages));
    }

    private static String concatenate(String[] messages) {
        return StringUtils.arrayToDelimitedString(messages, NEW_LINE);
    }
}
