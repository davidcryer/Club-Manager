package com.davidcryer.member.domain;

import com.davidcryer.common.IllegalArgsException;
import com.davidcryer.common.service.ApiException;
import com.davidcryer.member.controller.ApiMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository repository;

    @Autowired
    MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member create(final ApiMember apiMember) throws IllegalArgsException {
        return repository.save(Member.newInstance(apiMember.getFirstName(), apiMember.getLastName(), apiMember.getEmailAddress()));
    }

    public Iterable<Member> readAll() {
        return repository.findAll();
    }

    public Member update(final Member member, final ApiMember apiMember) throws IllegalArgsException {
        member.writer().firstName(apiMember.getFirstName()).lastName(apiMember.getLastName()).emailAddress(apiMember.getEmailAddress()).commit();
        return repository.save(member);
    }

    public void delete(final Long id) throws ApiException.NotFound {
        repository.delete(find(id));
    }

    public Member find(final long id) throws ApiException.NotFound {
        return repository.findOne(id);
    }
}
