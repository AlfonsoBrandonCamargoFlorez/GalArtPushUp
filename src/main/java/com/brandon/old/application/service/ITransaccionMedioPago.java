package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.TransaccionMedioPago;


public interface ITransaccionMedioPago {
    Optional<TransaccionMedioPago> findById(Long id);
    List<TransaccionMedioPago> getAll();
    TransaccionMedioPago save(TransaccionMedioPago categoria);
    TransaccionMedioPago update(Long id, TransaccionMedioPago categoria);
    void deleteById(Long id);

}
