package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.ClaseContacto;

public interface IClaseContacto {
    Optional<ClaseContacto> findById(Long id);
    List<ClaseContacto> getAll();
    ClaseContacto save(ClaseContacto categoria);
    ClaseContacto update(Long id, ClaseContacto categoria);
    void deleteById(Long id);

}
