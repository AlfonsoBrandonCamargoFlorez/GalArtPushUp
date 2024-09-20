package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.TipoDireccion;

public interface ITipoDireccion {
    Optional<TipoDireccion> findById(Long id);
    List<TipoDireccion> getAll();
    TipoDireccion save(TipoDireccion categoria);
    TipoDireccion update(Long id, TipoDireccion categoria);
    void deleteById(Long id);

}
