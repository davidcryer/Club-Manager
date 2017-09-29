package com.davidcryer.member.domain;

import com.davidcryer.common.domain.ArgsChecker;
import com.davidcryer.common.domain.InvalidArgsException;
import com.davidcryer.common.domain.StringUtils;

import javax.persistence.Entity;

@Entity
public class Member extends AnaemicMember {
    private final static String INVALID_FIELD_MESSAGE_FIRST_NAME = "firstName cannot be null or empty";
    private final static String INVALID_FIELD_MESSAGE_EMAIL_ADDRESS = "emailAddress cannot be null or empty";

    @SuppressWarnings("unused")
    Member() {}

    private Member(String firstName, String lastName, String emailAddress) {
        super(firstName, lastName, emailAddress);
    }

    public static Member newInstance(String firstName, String lastName, String emailAddress) throws InvalidArgsException {
        checkArgs(firstName, emailAddress);
        return new Member(firstName, lastName, emailAddress);
    }

    private static void checkArgs(String firstName, String emailAddress) throws InvalidArgsException {
        ArgsChecker.newInstance()
                .addCheck(() -> validFirstName(firstName), INVALID_FIELD_MESSAGE_FIRST_NAME)
                .addCheck(() -> validEmailAddress(emailAddress), INVALID_FIELD_MESSAGE_EMAIL_ADDRESS)
                .execute();
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

        public void firstName(final String firstName) {
            firstNameChanged = !StringUtils.equal(firstName, member.getFirstName());
            this.firstName = firstName;
        }

        public void lastName(final String lastName) {
            lastNameChanged = !StringUtils.equal(lastName, member.getLastName());
            this.lastName = lastName;
        }

        public void emailAddress(final String emailAddress) {
            emailAddressChanged = !StringUtils.equal(emailAddress, member.getEmailAddress());
            this.emailAddress = emailAddress;
        }

        public void commit() throws InvalidArgsException {
            checkFields();
            write();
        }

        private void checkFields() throws InvalidArgsException {
            if (firstNameChanged || emailAddressChanged) {
                final ArgsChecker argsChecker = ArgsChecker.newInstance();
                if (firstNameChanged) {
                    argsChecker.addCheck(() -> Member.validFirstName(firstName), INVALID_FIELD_MESSAGE_FIRST_NAME);
                }
                if (emailAddressChanged) {
                    argsChecker.addCheck(() -> Member.validEmailAddress(emailAddress), INVALID_FIELD_MESSAGE_EMAIL_ADDRESS);
                }
                argsChecker.execute();
            }
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
