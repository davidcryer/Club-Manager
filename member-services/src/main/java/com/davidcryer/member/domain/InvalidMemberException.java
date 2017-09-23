package com.davidcryer.member.domain;

import com.davidcryer.common.domain.InvalidEntityException;

class InvalidMemberException extends InvalidEntityException {
    private final static String TYPE = Member.class.getSimpleName();

    InvalidMemberException(String[] messages) {
        super(messages);
    }

    @Override
    public String entityType() {
        return TYPE;
    }
}
