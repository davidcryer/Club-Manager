package com.davidcryer.member.domain;

import com.davidcryer.common.domain.ArgsChecker;
import com.davidcryer.common.domain.IllegalArgsException;
import com.davidcryer.common.domain.StringUtils;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends AnaemicMember {
    final static String INVALID_FIELD_MESSAGE_FIRST_NAME = "firstName cannot be null or empty";
    final static String INVALID_FIELD_MESSAGE_EMAIL_ADDRESS = "emailAddress cannot be null or empty";

    @SuppressWarnings("unused")
    Member() {}

    private Member(String firstName, String lastName, String emailAddress) {
        super(firstName, lastName, emailAddress);
    }

    public static Member newInstance(String firstName, String lastName, String emailAddress) throws IllegalArgsException {
        checkArgs(firstName, emailAddress);
        return new Member(firstName, lastName, emailAddress);
    }

    private static void checkArgs(String firstName, String emailAddress) throws IllegalArgsException {
        ArgsChecker.runChecks(
                new ArgsChecker.Check(() -> validFirstName(firstName), INVALID_FIELD_MESSAGE_FIRST_NAME),
                new ArgsChecker.Check(() -> validEmailAddress(emailAddress), INVALID_FIELD_MESSAGE_EMAIL_ADDRESS)
        );
    }

    static boolean validFirstName(final String firstName) {
        return StringUtils.notNullOrEmpty(firstName);
    }

    static boolean validEmailAddress(final String emailAddress) {
        return StringUtils.notNullOrEmpty(emailAddress);
    }

    public Writer writer() {
        return new Writer(this);
    }

    public static class Writer {
        private final AnaemicMember member;
        private String firstName = null;
        private boolean firstNameChanged = false;
        private String lastName = null;
        private boolean lastNameChanged = false;
        private String emailAddress = null;
        private boolean emailAddressChanged = false;

        private Writer(AnaemicMember member) {
            this.member = member;
        }

        public Writer firstName(final String firstName) {
            firstNameChanged = !StringUtils.equal(firstName, member.getFirstName());
            this.firstName = firstName;
            return this;
        }

        public Writer lastName(final String lastName) {
            lastNameChanged = !StringUtils.equal(lastName, member.getLastName());
            this.lastName = lastName;
            return this;
        }

        public Writer emailAddress(final String emailAddress) {
            emailAddressChanged = !StringUtils.equal(emailAddress, member.getEmailAddress());
            this.emailAddress = emailAddress;
            return this;
        }

        public void commit() throws IllegalArgsException {
            checkFields();
            write();
        }

        private void checkFields() throws IllegalArgsException {
            if (firstNameChanged || emailAddressChanged) {
                ArgsChecker.runChecks(fieldChecks());
            }
        }

        private ArgsChecker.Check[] fieldChecks() {
            final List<ArgsChecker.Check> checks = new ArrayList<>();
            if (firstNameChanged) {
                checks.add(new ArgsChecker.Check(() -> Member.validFirstName(firstName), INVALID_FIELD_MESSAGE_FIRST_NAME));
            }
            if (emailAddressChanged) {
                checks.add(new ArgsChecker.Check(() -> Member.validEmailAddress(emailAddress), INVALID_FIELD_MESSAGE_EMAIL_ADDRESS));
            }
            return checks.toArray(new ArgsChecker.Check[checks.size()]);
        }

        private void write() {
            if (firstNameChanged) {
                member.setFirstName(firstName);
            }
            if (lastNameChanged) {
                member.setLastName(lastName);
            }
            if (emailAddressChanged) {
                member.setEmailAddress(emailAddress);
            }
        }
    }
}
