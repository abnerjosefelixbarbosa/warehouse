package com.exemple.backend.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemple.backend.entities.Function;

@Repository
public interface FunctionRepository extends JpaRepository<Function, UUID> {
	Optional<Function> findByName(String name);
}
