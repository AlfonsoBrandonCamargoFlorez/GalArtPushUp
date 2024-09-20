package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.MovCaja;

public interface IMovCaja {
    Optional<MovCaja> findById(Long id);
    List<MovCaja> getAll();
    MovCaja save(MovCaja categoria);
    MovCaja update(Long id, MovCaja categoria);
    void deleteById(Long id);

}
