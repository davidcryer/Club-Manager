package com.davidcryer.common.domain;

import org.springframework.util.StringUtils;

public abstract class InstantiationException extends RuntimeException {
    private final static String NEW_LINE = "\n";

    public InstantiationException(String[] messages) {
        super(concatenate(messages));
    }

    private static String concatenate(String[] messages) {
        return StringUtils.arrayToDelimitedString(messages, NEW_LINE);
    }

    public abstract String type();
}
