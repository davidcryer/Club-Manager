package com.davidcryer.member.domain;

import com.davidcryer.common.IllegalArgsException;
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

    public ApiMember.Response create(final ApiMember apiMember) throws IllegalArgsException {
        return apiMemberResponse(repository.save(Member.newInstance(apiMember.getFirstName(), apiMember.getLastName(), apiMember.getEmailAddress())));
    }

    public ApiMember.Response update(final Member member, final ApiMember apiMember) throws IllegalArgsException {
        member.writer().firstName(apiMember.getFirstName()).lastName(apiMember.getLastName()).emailAddress(apiMember.getEmailAddress()).commit();
        return apiMemberResponse(repository.save(member));
    }

    private static ApiMember.Response apiMemberResponse(final Member member) {
        return new ApiMember.Response(member.getId(), member.getFirstName(), member.getLastName(), member.getEmailAddress());
    }

    public void delete(final Long id) {
        repository.delete(id);
    }

    public Member find(final Long id) {
        return repository.findOne(id);
    }
}
