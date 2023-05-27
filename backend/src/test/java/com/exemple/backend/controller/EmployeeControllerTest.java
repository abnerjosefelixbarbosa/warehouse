package com.exemple.backend.controller;

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

import com.exemple.backend.entities.Employee;
import com.exemple.backend.entities.Function;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	@Disabled
	public void save() throws Exception {
		final Double SALARY_MANAGER = 3200.00D;
		final Double SALARY_COORDINATOR = 2200.00D;
		final Double SALARY_CHAGER = 1200.00D;
		
		Function function = new Function();
		function.setName("manager");
		
		Employee employee = new Employee();
		employee.setMatriculation(1111111111L);
		employee.setName("employee1");
		employee.setSalary(SALARY_MANAGER);
		employee.setFunction(function);
		
		final String URL = "/employees/save";
		final String CONTENT_TYPE = "application/json";
		final String ACCEPT = "application/json";
		final String JSON = objectMapper.writeValueAsString(employee);	
		
		mockMvc.perform(post(URL).contentType(CONTENT_TYPE).accept(ACCEPT).content(JSON))
		       .andDo(print())
		       .andExpect(status().is(201));
	}
	
	@Test
	@Disabled
	public void list() throws Exception {	
		final String URL = "/employees/list";
		final String ACCEPT = "application/json";
		
		mockMvc.perform(get(URL).accept(ACCEPT))
	           .andDo(print())
	           .andExpect(status().is(200));
	}
	
	@Test
	@Disabled
	public void findByMatriculation() throws Exception {
		final String URL = "/employees/find-by-matriculation/1111111111";
		final String ACCEPT = "application/json";
		
		mockMvc.perform(get(URL).accept(ACCEPT))
	           .andDo(print())
	           .andExpect(status().is(200));
	}
	
	@Test
	@Disabled
	public void update() throws Exception {
		final Double SALARY_MANAGER = 3200.00D;
		final Double SALARY_COORDINATOR = 2200.00D;
		final Double SALARY_CHAGER = 1200.00D;
		
		Function function = new Function();
		function.setName("manager");
		
		Employee employee = new Employee();
		employee.setName("employee1");
		employee.setSalary(SALARY_MANAGER);
		employee.setFunction(function);		
		
		final String URL = "/employees/update?matriculation=1111111111";
		final String CONTENT_TYPE = "application/json";
		final String ACCEPT = "application/json";
		final String JSON = objectMapper.writeValueAsString(employee);	
		
		mockMvc.perform(put(URL).contentType(CONTENT_TYPE).accept(ACCEPT).content(JSON))
               .andDo(print())
               .andExpect(status().is(200));
	}
}
