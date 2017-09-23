package com.davidcryer.member.domain;

import com.davidcryer.common.domain.ArgsChecker;
import com.davidcryer.common.domain.InvalidEntityException;
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

    public static Member newInstance(String firstName, String lastName, String emailAddress) throws InvalidEntityException {
        checkArgs(firstName, emailAddress);
        return new Member(firstName, lastName, emailAddress);
    }

    private static void checkArgs(String firstName, String emailAddress) throws InvalidEntityException {
        ArgsChecker.newInstance(InvalidMemberException::new)
                .check(() -> validFirstName(firstName), INVALID_FIELD_MESSAGE_FIRST_NAME)
                .check(() -> validEmailAddress(emailAddress), INVALID_FIELD_MESSAGE_EMAIL_ADDRESS)
                .throwIfChecksFailed();
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
        private boolean writeFirstName = false;
        private String lastName = null;
        private boolean writeLastName = false;
        private String emailAddress = null;
        private boolean writeEmailAddress = false;

        private Writer(AnaemicMember member) {
            this.member = member;
        }

        public void firstName(final String firstName) {
            writeFirstName = StringUtils.equal(firstName, member.getFirstName());
            this.firstName = firstName;
        }

        public void lastName(final String lastName) {
            writeLastName = StringUtils.equal(lastName, member.getLastName());
            this.lastName = lastName;
        }

        public void emailAddress(final String emailAddress) {
            writeEmailAddress = StringUtils.equal(emailAddress, member.getEmailAddress());
            this.emailAddress = emailAddress;
        }

        public void commit() throws InvalidEntityException {
            checkFields();
            write();
        }

        private void checkFields() throws InvalidEntityException {
            if (writeFirstName || writeEmailAddress) {
                final ArgsChecker argsChecker = ArgsChecker.newInstance(InvalidMemberException::new);
                if (writeFirstName) {
                    argsChecker.check(() -> Member.validFirstName(firstName), INVALID_FIELD_MESSAGE_FIRST_NAME);
                }
                if (writeEmailAddress) {
                    argsChecker.check(() -> Member.validEmailAddress(emailAddress), INVALID_FIELD_MESSAGE_EMAIL_ADDRESS);
                }
                argsChecker.throwIfChecksFailed();
            }
        }

        private void write() {
            if (writeFirstName) {
                member.setFirstName(firstName);
            }
            if (writeLastName) {
                member.setLastName(lastName);
            }
            if (writeEmailAddress) {
                member.setEmailAddress(emailAddress);
            }
        }
    }
}
