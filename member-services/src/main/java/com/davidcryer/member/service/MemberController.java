package com.davidcryer.member.service;

import com.davidcryer.common.IllegalArgsException;
import com.davidcryer.common.service.ApiException;
import com.davidcryer.member.domain.Member;
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
    public void createMember(@RequestBody final ApiMember apiMember) {
        try {
            memberService.create(apiMember);
        } catch (IllegalArgsException iae) {
            throw new ApiException.BadRequest(iae);
        }
    }

    @RequestMapping(value = "/members/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void setMember(@PathVariable(name = "id") final Long id, @RequestBody final ApiMember apiMember) {
        try {
            final Member member = find(id);
            memberService.update(member, apiMember);
        } catch (IllegalArgsException iae) {
            throw new ApiException.BadRequest(iae);
        }
    }

    private Member find(final long id) throws ApiException.NotFound {
        final Member member = memberService.find(id);
        if (member == null) {
            throw new ApiException.NotFound();
        }
        return member;
    }
}
