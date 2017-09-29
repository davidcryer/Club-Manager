package com.davidcryer.common.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArgsChecker {
    private final List<CheckResult> checkResults;

    private ArgsChecker(List<CheckResult> checkResults) {
        this.checkResults = checkResults;
    }

    public static ArgsChecker newInstance() {
        return new ArgsChecker(new LinkedList<>());
    }

    public ArgsChecker addCheck(final ArgCheck argCheck, final String failureMessage) {
        checkResults.add(new CheckResult(argCheck.passes(), failureMessage));
        return this;
    }

    public void execute() throws InvalidArgsException {
        throwExceptionIfFailedCheckExists();
    }

    private void throwExceptionIfFailedCheckExists() throws InvalidArgsException {
        if (hasFailedCheck()) {
            throwException();
        }
    }

    private boolean hasFailedCheck() {
        return !checkResults.stream().allMatch(CheckResult::passed);
    }

    private void throwException() throws InvalidArgsException {
        throw new InvalidArgsException(messagesFromFailedChecks());
    }

    private String[] messagesFromFailedChecks() {
        final List<String> messages = new ArrayList<>(checkResults.size());
        checkResults.forEach(wrapper -> {
            if (!wrapper.passed()) {
                messages.add(wrapper.failureMessage());
            }
        });
        return messages.toArray(new String[messages.size()]);
    }

    private static class CheckResult {
        private boolean checkPassed;
        private final String failureMessage;

        private CheckResult(boolean checkPassed, String failureMessage) {
            this.checkPassed = checkPassed;
            this.failureMessage = failureMessage;
        }

        boolean passed() {
            return checkPassed;
        }

        private String failureMessage() {
            return failureMessage;
        }
    }

    public interface ArgCheck {
        boolean passes();
    }
}
