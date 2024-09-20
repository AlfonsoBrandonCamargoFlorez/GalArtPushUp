package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.EstadoPersona;

public interface IEstadoPersona {
    Optional<EstadoPersona> findById(Long id);
    List<EstadoPersona> getAll();
    EstadoPersona save(EstadoPersona categoria);
    EstadoPersona update(Long id, EstadoPersona categoria);
    void deleteById(Long id);

}
