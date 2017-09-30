package com.davidcryer.member.service;

import com.davidcryer.common.IllegalArgsException;
import com.davidcryer.member.domain.MemberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MemberServiceTests {
    @MockBean
    private MemberRepository memberRepository;
    private MemberService memberService;

    @Before
    public void setup() {
        memberService = new MemberService(memberRepository);
    }

    @Test
    public void create() {
        memberService.create(new ApiMember("Cherline", null, "outlaw@country.com"));
    }

    @Test(expected = IllegalArgsException.class)
    public void createWithInvalidData() {
        memberService.create(new ApiMember(null, null, "outlaw@country.com"));
    }
}
