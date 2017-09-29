package com.davidcryer.common.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArgsChecker {

    private ArgsChecker() {}

    public static void runChecks(final Check... checks) throws IllegalArgsException {
        throwExceptionIfFailedCheckExists(Arrays.asList(checks));
    }

    private static void throwExceptionIfFailedCheckExists(final List<Check> checks) throws IllegalArgsException {
        if (hasFailedCheck(checks)) {
            throwException(messagesFromFailedChecks(checks));
        }
    }

    private static boolean hasFailedCheck(final List<Check> checks) {
        return !checks.stream().allMatch(Check::didPass);
    }

    private static String[] messagesFromFailedChecks(final List<Check> checks) {
        final List<String> messages = new ArrayList<>(checks.size());
        checks.forEach(check -> {
            if (!check.didPass()) {
                messages.add(check.failureMessage());
            }
        });
        return messages.toArray(new String[messages.size()]);
    }

    private static void throwException(final String[] failureMessages) throws IllegalArgsException {
        throw new IllegalArgsException(failureMessages);
    }

    public static class Check {
        private final boolean didPass;
        private final String failureMessage;

        public Check(ArgValidator argValidator, String failureMessage) {
            this.didPass = argValidator.argIsValid();
            this.failureMessage = failureMessage;
        }

        private boolean didPass() {
            return didPass;
        }

        private String failureMessage() {
            return failureMessage;
        }
    }

    public interface ArgValidator {
        boolean argIsValid();
    }
}
