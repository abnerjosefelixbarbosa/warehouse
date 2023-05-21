package com.exemple.backend.face;

import java.util.List;
import java.util.UUID;

import com.exemple.backend.entity.Function;

public interface FunctionFace {
	String save(Function function) throws Exception;
	List<Function> list();
	Function findById(UUID id);
	Function findByName(String name);
	String updata(Function function) throws Exception;
	String deleteById(UUID id);
}
