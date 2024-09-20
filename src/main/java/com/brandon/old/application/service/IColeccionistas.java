package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.Coleccionistas;

public interface IColeccionistas {
    Optional<Coleccionistas> findById(Long id);
    List<Coleccionistas> getAll();
    Coleccionistas save(Coleccionistas categoria);
    Coleccionistas update(Long id, Coleccionistas categoria);
    void deleteById(Long id);

}
