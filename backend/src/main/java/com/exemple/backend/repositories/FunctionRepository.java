package com.exemple.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemple.backend.entities.Function;

@Repository
public interface FunctionRepository extends JpaRepository<Function, String> {
	List<Function> findByOrderByName();
	Optional<Function> findByName(String name);
	boolean existsByName(String name);
}
