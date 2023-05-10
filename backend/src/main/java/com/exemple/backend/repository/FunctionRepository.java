package com.exemple.backend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.backend.entity.Function;

public interface FunctionRepository extends JpaRepository<Function, UUID> {
	boolean existsByFunction(String function);
	List<Function> findByFunctionLike(String function);
	Optional<Function> findByFunction(String function);
}
