package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.TipoPersona;

public interface ITipoPersona {
    Optional<TipoPersona> findById(Long id);
    List<TipoPersona> getAll();
    TipoPersona save(TipoPersona categoria);
    TipoPersona update(Long id, TipoPersona categoria);
    void deleteById(Long id);

}
