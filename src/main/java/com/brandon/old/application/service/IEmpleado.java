package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.Empleado;

public interface IEmpleado {
    Optional<Empleado> findById(Long id);
    List<Empleado> getAll();
    Empleado save(Empleado categoria);
    Empleado update(Long id, Empleado categoria);
    void deleteById(Long id);

}
