package com.brandon.old.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandon.old.domain.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
