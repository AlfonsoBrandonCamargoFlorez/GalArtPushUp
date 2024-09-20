package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.Genero;

public interface IGenero {
    Optional<Genero> findById(Long id);
    List<Genero> getAll();
    Genero save(Genero categoria);
    Genero update(Long id, Genero categoria);
    void deleteById(Long id);

}
