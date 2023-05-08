package com.exemple.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.exemple.backend.entity.Function;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class FunctionControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	//@Disabled
	public void create() throws Exception {
		Function function1 = new Function();
		function1.setFunction("maneger");		
		
		Function function2 = new Function();
		function2.setFunction("coordinator");
		
		Function function3 = new Function();
		function3.setFunction("charger");
		
		String url = "/functions/create";
		String contentType = "application/json";
		String json = objectMapper.writeValueAsString(function1);
		
		mockMvc.perform(post(url).contentType(contentType).content(json))
		       .andDo(print())
		       .andExpect(status().is(200));
	}
}
