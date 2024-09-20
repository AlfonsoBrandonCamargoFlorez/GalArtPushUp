package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.Ciudades;

public interface ICiudades {
    Optional<Ciudades> findById(Long id);
    List<Ciudades> getAll();
    Ciudades save(Ciudades categoria);
    Ciudades update(Long id, Ciudades categoria);
    void deleteById(Long id);

}
