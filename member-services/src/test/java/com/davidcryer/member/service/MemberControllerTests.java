package com.davidcryer.member.service;

import com.davidcryer.common.ArgsInspector;
import com.davidcryer.member.domain.Member;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest()
public class MemberControllerTests {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private MemberService memberService;

    @Test
    public void createMember() throws Exception {
        final ApiMember apiMember = new ApiMember("Cherline", null, "outlaw@country.com");
        mvc.perform(post("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(apiMember)))
                .andExpect(status().isCreated());
    }

    @Test
    public void createMemberWithInvalidData() throws Exception {
        final ApiMember apiMember = new ApiMember(null, null, "outlaw@country.com");
        when(memberService.create(apiMember)).then((Answer<Member>) invocation -> {
            ArgsInspector.inspect(ArgsInspector.check(() -> false, ""));
            return null;
        });
        mvc.perform(post("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(apiMember)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void putMember() throws Exception {
        final Member stored = Member.newInstance("Cherline", null, "outlaw@country.com");
        when(memberService.find(1L)).thenReturn(stored);
        final ApiMember apiMember = new ApiMember("Cheryl", "Tunt", "outlaw@country.com");
        mvc.perform(put("/members/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(apiMember)))
                .andExpect(status().isAccepted());
    }

    @Test
    public void putMemberWithNonExistentId() throws Exception {
        when(memberService.find(1L)).thenReturn(null);
        final ApiMember apiMember = new ApiMember("Cheryl", "Tunt", "outlaw@country.com");
        mvc.perform(put("/members/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(apiMember)))
                .andExpect(status().isNotFound());
    }
}
