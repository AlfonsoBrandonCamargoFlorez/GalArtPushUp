package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.Despachos;

public interface IDespachos {
    Optional<Despachos> findById(Long id);
    List<Despachos> getAll();
    Despachos save(Despachos categoria);
    Despachos update(Long id, Despachos categoria);
    void deleteById(Long id);

}
