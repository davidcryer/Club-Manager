package com.davidcryer.member.controller;

import com.davidcryer.common.IllegalArgsException;
import com.davidcryer.common.service.ApiException;
import com.davidcryer.member.domain.Member;
import com.davidcryer.member.domain.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

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
            return memberResponse(memberService.create(member));
        } catch (IllegalArgsException iae) {
            throw new ApiException.BadRequest(iae);
        }
    }

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public List<ApiMember.Response> get() {
        final List<ApiMember.Response> memberResponses = new LinkedList<>();
        memberService.readAll().forEach(member -> memberResponses.add(memberResponse(member)));
        return memberResponses;
    }

    @RequestMapping(value = "/members/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public ApiMember.Response get(@PathVariable(name = "id") final Long id) {
        return memberResponse(find(id));
    }

    @RequestMapping(value = "/members/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public ApiMember.Response put(@PathVariable(name = "id") final Long id, @RequestBody final ApiMember.Request member) {
        try {
            return memberResponse(memberService.update(find(id), member));
        } catch (IllegalArgsException iae) {
            throw new ApiException.BadRequest(iae);
        }
    }

    @RequestMapping(value = "/members/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") final Long id) {
        memberService.delete(id);
    }

    @RequestMapping(value = "path", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String getURLBase(HttpServletRequest request) throws MalformedURLException {
        URL requestURL = new URL(request.getRequestURL().toString());
        String port = requestURL.getPort() == -1 ? "" : ":" + requestURL.getPort();
        return requestURL.getProtocol() + "://" + requestURL.getHost() + port;

    }

    private Member find(final Long id) {
        final Member member = memberService.find(id);
        if (member == null) {
            throw new ApiException.NotFound(String.format("No member found with id %1$d", id));
        }
        return member;
    }

    private static ApiMember.Response memberResponse(final Member member) {
        return new ApiMember.Response(member.getId(), member.getFirstName(), member.getLastName(), member.getEmailAddress());
    }
}
