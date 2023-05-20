package com.exemple.backend.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemple.backend.entity.Function;

@Repository
public interface FunctionRepository extends JpaRepository<Function, UUID> {
	boolean existsByName(String name);
	Optional<Function> findByName(String name);
}
