package com.davidcryer.member.domain;

import com.davidcryer.common.domain.ArgsChecker;
import com.davidcryer.common.domain.InstantiationException;
import com.davidcryer.common.domain.StringUtils;

import javax.persistence.Entity;

@Entity
public class Member extends AnaemicMember {

    Member() {}

    private Member(String firstName, String lastName, String emailAddress) {
        super(firstName, lastName, emailAddress);
    }

    private static Member newInstance(String firstName, String lastName, String emailAddress) throws InstantiationException {
        checkArgs(firstName, lastName, emailAddress);
        return new Member(firstName, lastName, emailAddress);
    }

    private static void checkArgs(String firstName, String lastName, String emailAddress) throws InstantiationException {
        ArgsChecker.newInstance(MemberInstantiationException::new)
                .check(() -> StringUtils.notNullOrEmpty(firstName), () -> "firstName cannot be null or empty")
                .check(() -> StringUtils.notNullOrEmpty(emailAddress), () -> "emailAddress cannot be null or empty")
                .throwIfChecksFailed();
    }
}
