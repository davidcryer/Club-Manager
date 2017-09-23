package com.davidcryer.member.domain;

import com.davidcryer.common.domain.InstantiationException;

class MemberInstantiationException extends InstantiationException {
    private final static String TYPE = Member.class.getSimpleName();

    MemberInstantiationException(String[] messages) {
        super(messages);
    }

    @Override
    public String type() {
        return TYPE;
    }
}
