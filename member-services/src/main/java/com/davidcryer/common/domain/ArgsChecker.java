package com.davidcryer.common.domain;

import java.util.ArrayList;
import java.util.Collection;

public class ArgsChecker {
    private boolean checksFailed;
    private final Collection<String> failureMessages;
    private final ExceptionProvider exceptionProvider;

    private ArgsChecker(boolean checksFailed, Collection<String> failureMessages, ExceptionProvider exceptionProvider) {
        this.checksFailed = checksFailed;
        this.failureMessages = failureMessages;
        this.exceptionProvider = exceptionProvider;
    }

    public static ArgsChecker newInstance(final ExceptionProvider exceptionProvider) {
        return newInstance(exceptionProvider, new ArrayList<>());
    }

    public static ArgsChecker newInstance(final ExceptionProvider exceptionProvider, final int fieldCount) {
        return newInstance(exceptionProvider, new ArrayList<>(fieldCount));
    }

    private static ArgsChecker newInstance(final ExceptionProvider exceptionProvider, final Collection<String> emptyMessages) {
        if (!emptyMessages.isEmpty()) {emptyMessages.clear();}
        return new ArgsChecker(false, emptyMessages, exceptionProvider);
    }

    public ArgsChecker check(final Arg arg, final String failureMessage) {
        if (!arg.isValid()) {
            checksFailed = true;
            failureMessages.add(failureMessage);
        }
        return this;
    }

    public void throwIfChecksFailed() throws InvalidEntityException {
        if (checksFailed) {
            throw exceptionProvider.exception(failureMessages.toArray(new String[failureMessages.size()]));
        }
    }

    public interface Arg {
        boolean isValid();
    }

    public interface ExceptionProvider {
        InvalidEntityException exception(String[] messages);
    }
}
