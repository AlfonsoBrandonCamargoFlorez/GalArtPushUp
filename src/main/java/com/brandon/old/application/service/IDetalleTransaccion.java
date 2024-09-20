package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.DetalleTransaccion;

public interface IDetalleTransaccion {
    Optional<DetalleTransaccion> findById(Long id);
    List<DetalleTransaccion> getAll();
    DetalleTransaccion save(DetalleTransaccion categoria);
    DetalleTransaccion update(Long id, DetalleTransaccion categoria);
    void deleteById(Long id);

}
