package com.davidcryer.common.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArgsInspector {

    private ArgsInspector() {}

    public static void inspect(final CheckResult... checkResults) throws IllegalArgsException {
        throwExceptionIfFailedCheckExists(Arrays.asList(checkResults));
    }

    private static void throwExceptionIfFailedCheckExists(final List<CheckResult> checkResults) throws IllegalArgsException {
        if (hasFailedCheck(checkResults)) {
            throwException(messagesFromFailedChecks(checkResults));
        }
    }

    private static boolean hasFailedCheck(final List<CheckResult> checkResults) {
        return !checkResults.stream().allMatch(CheckResult::didPass);
    }

    private static String[] messagesFromFailedChecks(final List<CheckResult> checkResults) {
        final List<String> messages = new ArrayList<>(checkResults.size());
        checkResults.forEach(checkResult -> {
            if (!checkResult.didPass()) {
                messages.add(checkResult.failureMessage());
            }
        });
        return messages.toArray(new String[messages.size()]);
    }

    private static void throwException(final String[] failureMessages) throws IllegalArgsException {
        throw new IllegalArgsException(failureMessages);
    }

    public static CheckResult check(ArgValidator argValidator, String failureMessage) {
        return new CheckResult(argValidator, failureMessage);
    }

    public static class CheckResult {
        private final boolean didPass;
        private final String failureMessage;

        private CheckResult(ArgValidator argValidator, String failureMessage) {
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
