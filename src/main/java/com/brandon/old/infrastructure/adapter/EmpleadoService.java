package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IEmpleado;
import com.brandon.old.domain.entities.Empleado;
import com.brandon.old.infrastructure.repository.EmpleadoRepository;

@Service
public class EmpleadoService implements IEmpleado {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Optional<Empleado> findById(Long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public List<Empleado> getAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado update(Long id, Empleado empleado) {
        return empleadoRepository.findById(id)
            .map(existingEmpleado -> {
                existingEmpleado.setNombre(empleado.getNombre());
                existingEmpleado.setApellido(empleado.getApellido());
                existingEmpleado.setPuesto(empleado.getPuesto());
                existingEmpleado.setSalario(empleado.getSalario());
                existingEmpleado.setComision(empleado.getComision());
                existingEmpleado.setFechaContratacion(empleado.getFechaContratacion());
                existingEmpleado.setPersona(empleado.getPersona());
                return empleadoRepository.save(existingEmpleado);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        empleadoRepository.deleteById(id);
    }
}
