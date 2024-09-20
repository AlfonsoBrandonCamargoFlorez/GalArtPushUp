package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.Empresa;

public interface IEmpresa {
    Optional<Empresa> findById(Long id);
    List<Empresa> getAll();
    Empresa save(Empresa categoria);
    Empresa update(Long id, Empresa categoria);
    void deleteById(Long id);

}
