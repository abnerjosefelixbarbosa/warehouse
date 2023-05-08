package com.exemple.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.backend.entity.Function;

public interface FunctionRepository extends JpaRepository<Function, UUID> {
	boolean existsByFunction(String function);
}
