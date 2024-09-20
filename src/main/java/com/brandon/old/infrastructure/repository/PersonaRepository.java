package com.brandon.old.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandon.old.domain.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
