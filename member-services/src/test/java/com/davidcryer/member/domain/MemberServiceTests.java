package com.davidcryer.member.domain;

import com.davidcryer.common.IllegalArgsException;
import com.davidcryer.member.controller.ApiMember;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.any;

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
        final ApiMember.Request request = new ApiMember.Request("Cherline", null, "outlaw@country.com");
        Mockito.when(memberRepository.save(any(Member.class))).thenReturn(Member.newInstance(request.getFirstName(), request.getLastName(), request.getEmailAddress()));
        final ApiMember.Response response = memberService.create(request);
        Assert.assertEquals(response.getFirstName(), request.getFirstName());
        Assert.assertEquals(response.getLastName(), request.getLastName());
        Assert.assertEquals(response.getEmailAddress(), request.getEmailAddress());
    }

    @Test(expected = IllegalArgsException.class)
    public void createWithInvalidData() {
        memberService.create(new ApiMember.Request(null, null, "outlaw@country.com"));
    }

    @Test(expected = IllegalArgsException.class)
    public void updateWithInvalidData() {
        memberService.update(
                Member.newInstance("Cherline", null, "outlaw@country.com"),
                new ApiMember.Request(null, null, "outlaw@country.com")
        );
    }
}
