package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.Categorias;

public interface ICategorias {
    Optional<Categorias> findById(Long id);
    List<Categorias> getAll();
    Categorias save(Categorias categoria);
    Categorias update(Long id, Categorias categoria);
    void deleteById(Long id);

}
