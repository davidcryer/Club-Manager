package com.davidcryer.member.controller;

import com.davidcryer.common.IllegalArgsException;
import com.davidcryer.common.service.ApiException;
import com.davidcryer.member.domain.Member;
import com.davidcryer.member.domain.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(value = "/members", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ApiMember.Response post(@RequestBody final ApiMember.Request member) {
        try {
            return memberService.create(member);
        } catch (IllegalArgsException iae) {
            throw new ApiException.BadRequest(iae);
        }
    }

    @RequestMapping(value = "/members/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public ApiMember.Response put(@PathVariable(name = "id") final Long id, @RequestBody final ApiMember.Request member) {
        try {
            return memberService.update(find(id), member);
        } catch (IllegalArgsException iae) {
            throw new ApiException.BadRequest(iae);
        }
    }

    private Member find(final long id) throws ApiException.NotFound {
        final Member member = memberService.find(id);
        if (member == null) {
            throw new ApiException.NotFound(String.format("No member found with id %1$d", id));
        }
        return member;
    }

    @RequestMapping(value = "/members/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") final Long id) {
        memberService.delete(id);
    }
}
