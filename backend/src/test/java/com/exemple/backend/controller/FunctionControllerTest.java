package com.exemple.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
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
	@Disabled
	public void save() throws Exception {
		Function function1 = new Function();
		function1.setName("function1");		
		Function function2 = new Function();
		function2.setName("function2");
		Function function3 = new Function();
		function3.setName("function3");
		final String URL = "/functions/save";
		final String CONTENT_TYPE = "application/json";
		final String ACCEPT = "application/json";
		final String JSON = objectMapper.writeValueAsString(function2);	
		mockMvc.perform(post(URL).contentType(CONTENT_TYPE).accept(ACCEPT).content(JSON))
		       .andDo(print())
		       .andExpect(status().is(201));
	}
	
	@Test
	@Disabled
	public void list() throws Exception {
		final String URL = "/functions/list";
		final String ACCEPT = "application/json";		
		mockMvc.perform(get(URL).accept(ACCEPT))
		       .andDo(print())
		       .andExpect(status().is(200));
	}
	
	@Test
	@Disabled
	public void findById() throws Exception {
		final String URL = "/functions/find-by-id/31bf1bdb-49a0-4cb8-bdee-0c88679fc8a8";
		final String ACCEPT = "application/json";		
		mockMvc.perform(get(URL).accept(ACCEPT))
		       .andDo(print())
		       .andExpect(status().is(200));
	}
	
	@Test
	@Disabled
	public void findByName() throws Exception {
		final String URL = "/functions/find-by-name/function1";
		final String ACCEPT = "application/json";		
		mockMvc.perform(get(URL).accept(ACCEPT))
		       .andDo(print())
		       .andExpect(status().is(200));
	}
	
	@Test
	@Disabled
	public void update() throws Exception {
		Function function1 = new Function();
		function1.setName("function1");		
		Function function2 = new Function();
		function2.setName("function2");		
		Function function3 = new Function();
		function3.setName("function3");		
		Function function4 = new Function();
		function4.setName("function4");		
		final String URL = "/functions/update/31bf1bdb-49a0-4cb8-bdee-0c88679fc8a8";
		final String CONTENT_TYPE = "application/json";
		final String ACCEPT = "application/json";
		final String JSON = objectMapper.writeValueAsString(function1);
		mockMvc.perform(put(URL).contentType(CONTENT_TYPE).accept(ACCEPT).content(JSON))
		       .andDo(print())
		       .andExpect(status().is(200));
	}
	
	@Test
	//@Disabled
	public void deleteById() throws Exception {
		final String URL = "/functions/delete-by-id/31bf1bdb-49a0-4cb8-bdee-0c88679fc8a8";
		final String ACCEPT = "application/json";		
		mockMvc.perform(delete(URL).accept(ACCEPT))
		       .andDo(print())
		       .andExpect(status().is(200));
	}
}
