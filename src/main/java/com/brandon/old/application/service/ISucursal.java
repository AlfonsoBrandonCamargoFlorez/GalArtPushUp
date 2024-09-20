package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.Sucursal;

public interface ISucursal {
    Optional<Sucursal> findById(Long id);
    List<Sucursal> getAll();
    Sucursal save(Sucursal categoria);
    Sucursal update(Long id, Sucursal categoria);
    void deleteById(Long id);

}
