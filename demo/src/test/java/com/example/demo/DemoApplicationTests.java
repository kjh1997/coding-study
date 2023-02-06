package com.example.demo;

import com.example.demo.account.Account;
import com.example.demo.account.AccountController;
import com.example.demo.account.dto.AccountDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {
	@Autowired
	private MockMvc mockMvc;


//	@Test
//
//	public void testController() throws Exception {
//		System.out.println();
//		mockMvc.perform(
//				get("/")
//						.accept(MediaType.APPLICATION_JSON)
//		)
//				.andExpect(jsonPath("code", is(400)))
//				.andExpect(jsonPath("message", is("fail")));
//	}

	@Test
	@DisplayName("회원가입")
	@Transactional
	public void signUpTest() throws Exception {
		ObjectMapper om = new ObjectMapper();
		AccountDTO accountDTO = AccountDTO.builder().name("TEST3").role(Role.ADMIN).build();
		String content = om.writeValueAsString(accountDTO);

		mockMvc.perform(
						post("/account/save")
								.content(content)
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)

				)
				.andExpect(jsonPath("code", is(200)))
				.andExpect(jsonPath("message", is("회원가입에 성공하셨습니다.")));

	}
}
