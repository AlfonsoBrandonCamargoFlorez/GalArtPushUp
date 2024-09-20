package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.TipoTransaccion;

public interface ITipoTransaccion {
    Optional<TipoTransaccion> findById(Long id);
    List<TipoTransaccion> getAll();
    TipoTransaccion save(TipoTransaccion categoria);
    TipoTransaccion update(Long id, TipoTransaccion categoria);
    void deleteById(Long id);

}
