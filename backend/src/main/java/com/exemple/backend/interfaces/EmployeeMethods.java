package com.exemple.backend.interfaces;

import java.util.List;

import com.exemple.backend.entities.Employee;

public interface EmployeeMethods {
	String save(Employee employee) throws Exception;
	List<Employee> list();
}
