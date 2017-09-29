package com.davidcryer.member.service;

import com.davidcryer.common.service.ApiMember;
import com.davidcryer.member.domain.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
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
    private MemberRepository memberRepository;

    @Test
    public void createMember() throws Exception {
        final Object apiMember = new ApiMember("Cherline", null, "outlaw@country.com");
        mvc.perform(post("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(apiMember)))
                .andExpect(status().isCreated());
    }

    @Test
    public void failToCreateMember() throws Exception {
        final Object apiMember = new ApiMember(null, null, "outlaw@country.com");
        mvc.perform(post("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(apiMember)))
                .andExpect(status().isBadRequest());
    }
}
