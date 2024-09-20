package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.DireccionPersona;

public interface IDireccionPersona {
    Optional<DireccionPersona> findById(Long id);
    List<DireccionPersona> getAll();
    DireccionPersona save(DireccionPersona categoria);
    DireccionPersona update(Long id, DireccionPersona categoria);
    void deleteById(Long id);

}
