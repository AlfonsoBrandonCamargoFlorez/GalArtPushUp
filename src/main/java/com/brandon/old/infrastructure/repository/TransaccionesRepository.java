package com.brandon.old.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandon.old.domain.entities.Transacciones;

public interface TransaccionesRepository extends JpaRepository<Transacciones, Long>{

}
