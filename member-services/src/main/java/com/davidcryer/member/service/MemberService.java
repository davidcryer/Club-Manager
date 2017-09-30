package com.davidcryer.member.service;

import com.davidcryer.common.IllegalArgsException;
import com.davidcryer.member.domain.Member;
import com.davidcryer.member.domain.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class MemberService {
    private final MemberRepository repository;

    @Autowired
    MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    void create(final ApiMember apiMember) throws IllegalArgsException {
        repository.save(Member.newInstance(apiMember.getFirstName(), apiMember.getLastName(), apiMember.getEmailAddress()));
    }

    void update(final Member member, final ApiMember apiMember) throws IllegalArgsException {
        member.writer().firstName(apiMember.getFirstName()).lastName(apiMember.getLastName()).emailAddress(apiMember.getEmailAddress()).commit();
        repository.save(member);
    }

    Member find(final long id) {
        return repository.findOne(id);
    }
}
