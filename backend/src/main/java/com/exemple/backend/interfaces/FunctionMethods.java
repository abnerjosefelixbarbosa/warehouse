package com.exemple.backend.interfaces;

import java.util.List;

import com.exemple.backend.entities.Function;

public interface FunctionMethods {
	String save(Function function);
	List<Function> list();
	Function findByName(String name);
	String updata(Function function);
	String deleteById(String id);
}
