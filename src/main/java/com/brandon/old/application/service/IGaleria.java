package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.Galeria;

public interface IGaleria {
    Optional<Galeria> findById(Long id);
    List<Galeria> getAll();
    Galeria save(Galeria categoria);
    Galeria update(Long id, Galeria categoria);
    void deleteById(Long id);

}
