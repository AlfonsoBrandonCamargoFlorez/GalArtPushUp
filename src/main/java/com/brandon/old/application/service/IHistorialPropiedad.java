package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.HistorialPropiedad;

public interface IHistorialPropiedad {
    Optional<HistorialPropiedad> findById(Long id);
    List<HistorialPropiedad> getAll();
    HistorialPropiedad save(HistorialPropiedad categoria);
    HistorialPropiedad update(Long id, HistorialPropiedad categoria);
    void deleteById(Long id);

}
