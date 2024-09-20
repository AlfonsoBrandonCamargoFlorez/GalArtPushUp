package com.brandon.old.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandon.old.domain.entities.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
