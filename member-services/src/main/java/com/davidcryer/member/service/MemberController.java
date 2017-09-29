package com.davidcryer.member.service;

import com.davidcryer.common.service.ApiMember;
import com.davidcryer.member.domain.Member;
import com.davidcryer.member.domain.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController(value = "members")
public class MemberController {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createMember(@RequestBody final ApiMember apiMember) {
        memberRepository.save(Member.newInstance(apiMember.getFirstName(), apiMember.getLastName(), apiMember.getEmailAddress()));
    }
}
