package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.Transacciones;

public interface ITransacciones {
    Optional<Transacciones> findById(Long id);
    List<Transacciones> getAll();
    Transacciones save(Transacciones categoria);
    Transacciones update(Long id, Transacciones categoria);
    void deleteById(Long id);

}
