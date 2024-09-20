package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.TipoMovCaja;

public interface ITipoMovCaja {
    Optional<TipoMovCaja> findById(Long id);
    List<TipoMovCaja> getAll();
    TipoMovCaja save(TipoMovCaja categoria);
    TipoMovCaja update(Long id, TipoMovCaja categoria);
    void deleteById(Long id);

}
