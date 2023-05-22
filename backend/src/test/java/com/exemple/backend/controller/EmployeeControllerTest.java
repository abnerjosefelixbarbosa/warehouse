package com.exemple.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
		
		Function function1 = new Function();
		function1.setName("manager");
		
		Function function2 = new Function();
		function2.setName("coordinator");
		
		Employee employee1 = new Employee();
		employee1.setMatriculation(1111111111L);
		employee1.setName("employee1");
		employee1.setSalary(SALARY_MANAGER);
		employee1.setFunction(function1);
		
		Employee employee2 = new Employee();
		employee2.setMatriculation(2222222222L);
		employee2.setName("employee2");
		employee2.setSalary(SALARY_COORDINATOR);
		employee2.setFunction(function2);
		
		Employee employee3 = new Employee();
		employee3.setMatriculation(3333333333L);
		employee3.setName("employee3");
		employee3.setSalary(SALARY_COORDINATOR);
		employee3.setFunction(function2);
		
		Employee employee4 = new Employee();
		employee4.setMatriculation(4444444444L);
		employee4.setName("employee4");
		employee4.setSalary(SALARY_COORDINATOR);
		employee4.setFunction(function2);
		
		Employee employee5 = new Employee();
		employee5.setMatriculation(5555555555L);
		employee5.setName("employee5");
		employee5.setSalary(SALARY_MANAGER);
		employee5.setFunction(function1);
		
		Employee employee6 = new Employee();
		employee6.setMatriculation(5555555555L);
		employee6.setName("employee5");
		employee6.setSalary(SALARY_COORDINATOR);
		employee6.setFunction(function2);
		
		final String URL = "/employees/save";
		final String CONTENT_TYPE = "application/json";
		final String ACCEPT = "application/json";
		final String JSON = objectMapper.writeValueAsString(employee6);	
		
		mockMvc.perform(post(URL).contentType(CONTENT_TYPE).accept(ACCEPT).content(JSON))
		       .andDo(print())
		       .andExpect(status().is(201));
	}
}
