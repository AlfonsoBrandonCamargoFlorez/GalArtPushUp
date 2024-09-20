package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.EstacionPago;

public interface IEstacionPago {
    Optional<EstacionPago> findById(Long id);
    List<EstacionPago> getAll();
    EstacionPago save(EstacionPago categoria);
    EstacionPago update(Long id, EstacionPago categoria);
    void deleteById(Long id);

}
