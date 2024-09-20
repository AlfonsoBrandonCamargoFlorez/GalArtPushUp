package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.MedioPago;

public interface IMedioPago {
    Optional<MedioPago> findById(Long id);
    List<MedioPago> getAll();
    MedioPago save(MedioPago categoria);
    MedioPago update(Long id, MedioPago categoria);
    void deleteById(Long id);

}
