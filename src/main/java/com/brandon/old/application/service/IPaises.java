package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.Paises;

public interface IPaises {
    Optional<Paises> findById(Long id);
    List<Paises> getAll();
    Paises save(Paises categoria);
    Paises update(Long id, Paises categoria);
    void deleteById(Long id);

}
