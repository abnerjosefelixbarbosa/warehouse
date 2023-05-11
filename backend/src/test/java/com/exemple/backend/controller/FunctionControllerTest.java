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
	public void create() throws Exception {
		Function function1 = new Function();
		function1.setFunction("function1");		
		
		Function function2 = new Function();
		function2.setFunction("function2");
		
		Function function3 = new Function();
		function3.setFunction("function3");
		
		String url = "/functions/create";
		String contentType = "application/json";
		String accept = "application/json";
		String json = objectMapper.writeValueAsString(function1);
		
		mockMvc.perform(post(url).contentType(contentType).accept(accept).content(json))
		       .andDo(print())
		       .andExpect(status().is(200));
	}
	
	@Test
	@Disabled
	public void updata() throws Exception {
		Function function1 = new Function();
		function1.setFunction("function1");		
		
		Function function2 = new Function();
		function2.setFunction("function2");
		
		Function function3 = new Function();
		function3.setFunction("function3");
		
		String url = "/functions/updata/f3140f21-240b-472d-abfd-69732b3d5dbd";
		String contentType = "application/json";
		String accept = "application/json";
		String json = objectMapper.writeValueAsString(function1);
		
		mockMvc.perform(put(url).contentType(contentType).accept(accept).content(json))
		       .andDo(print())
		       .andExpect(status().is(200));
	}
	
	@Test
	@Disabled
	public void list() throws Exception {
		String url = "/functions/list";
		String accept = "application/json";
		
		mockMvc.perform(get(url).accept(accept))
		       .andDo(print())
		       .andExpect(status().is(200));
	}
	
	@Test
	@Disabled
	public void findById() throws Exception {
		String url = "/functions/find-by-id/f3140f21-240b-472d-abfd-69732b3d5dbd";
		String accept = "application/json";
		
		mockMvc.perform(get(url).accept(accept))
		       .andDo(print())
		       .andExpect(status().is(200));
	}
	
	@Test
	@Disabled
	public void findByFunction() throws Exception {
		String url = "/functions/find-by-function/maneger";
		String accept = "application/json";
		
		mockMvc.perform(get(url).accept(accept))
		       .andDo(print())
		       .andExpect(status().is(200));
	}
	
	@Test
	@Disabled
	public void deleteById() throws Exception {
		String url = "/functions/delete-by-id/f3140f21-240b-472d-abfd-69732b3d5dbd";
		String accept = "application/json";
		
		mockMvc.perform(delete(url).accept(accept))
		       .andDo(print())
		       .andExpect(status().is(200));
	}
}
