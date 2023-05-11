package com.exemple.backend.face;

import java.util.List;
import java.util.UUID;

import com.exemple.backend.entity.Function;

public interface FunctionFace {
	void save(Function function);
	void validCreate(Function function) throws Exception;
	void validUpdata(Function function) throws Exception;
	List<Function> findAll();
	Function findById(UUID id);
	Function findByFunction(String function);
	void deleteById(UUID id);
}
