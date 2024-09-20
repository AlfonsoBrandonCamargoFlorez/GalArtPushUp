package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.Persona;

public interface IPersona {
    Optional<Persona> findById(Long id);
    List<Persona> getAll();
    Persona save(Persona categoria);
    Persona update(Long id, Persona categoria);
    void deleteById(Long id);

}
