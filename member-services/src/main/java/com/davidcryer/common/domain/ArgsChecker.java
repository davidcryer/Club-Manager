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

    private static <E extends InstantiationException> ArgsChecker newInstance(final ExceptionProvider exceptionProvider, final Collection<String> emptyMessages) {
        if (!emptyMessages.isEmpty()) {emptyMessages.clear();}
        return new ArgsChecker(false, emptyMessages, exceptionProvider);
    }

    public ArgsChecker check(final CheckExecutor executor, final InvalidArgMessageProvider messageProvider) {
        if (!executor.isValid()) {
            checksFailed = true;
            failureMessages.add(messageProvider.message());
        }
        return this;
    }

    public void throwIfChecksFailed() throws InstantiationException {
        if (checksFailed) {
            throw exceptionProvider.exception(failureMessages.toArray(new String[failureMessages.size()]));
        }
    }

    public interface CheckExecutor {
        boolean isValid();
    }

    public interface InvalidArgMessageProvider {
        String message();
    }

    public interface ExceptionProvider {
        InstantiationException exception(String[] messages);
    }
}
