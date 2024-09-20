package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.Regiones;

public interface IRegiones {
    Optional<Regiones> findById(Long id);
    List<Regiones> getAll();
    Regiones save(Regiones categoria);
    Regiones update(Long id, Regiones categoria);
    void deleteById(Long id);

}
