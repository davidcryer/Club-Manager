package com.davidcryer.common.domain;

import org.springframework.util.StringUtils;

public abstract class InvalidEntityException extends RuntimeException {
    private final static String NEW_LINE = "\n";

    public InvalidEntityException(String[] messages) {
        super(concatenate(messages));
    }

    private static String concatenate(String[] messages) {
        return StringUtils.arrayToDelimitedString(messages, NEW_LINE);
    }

    public abstract String entityType();
}
