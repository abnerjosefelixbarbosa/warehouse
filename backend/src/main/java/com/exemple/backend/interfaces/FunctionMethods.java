package com.exemple.backend.interfaces;

import java.util.List;
import java.util.UUID;

import com.exemple.backend.entities.Function;

public interface FunctionMethods {
	String save(Function function) throws Exception;
	List<Function> list();
	Function findByName(String name);
	String updata(Function function) throws Exception;
	String deleteById(UUID id);
}
