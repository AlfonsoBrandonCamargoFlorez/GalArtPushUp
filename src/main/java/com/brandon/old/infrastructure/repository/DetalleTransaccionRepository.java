package com.brandon.old.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandon.old.domain.entities.DetalleTransaccion;

public interface DetalleTransaccionRepository extends JpaRepository<DetalleTransaccion, Long>{

}
