package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.ICiudades;
import com.brandon.old.domain.entities.Ciudades;
import com.brandon.old.infrastructure.repository.CiudadesRepository;

@Service
public class CiudadesService implements ICiudades {

    @Autowired
    private CiudadesRepository ciudadesRepository;

    @Override
    public Optional<Ciudades> findById(Long id) {
        return ciudadesRepository.findById(id);
    }

    @Override
    public List<Ciudades> getAll() {
        return ciudadesRepository.findAll();
    }

    @Override
    public Ciudades save(Ciudades ciudad) {
        return ciudadesRepository.save(ciudad);
    }

    @Override
    public Ciudades update(Long id, Ciudades ciudad) {
        return ciudadesRepository.findById(id)
            .map(existingCiudad -> {
                existingCiudad.setNombre(ciudad.getNombre());
                existingCiudad.setRegiones(ciudad.getRegiones());
                existingCiudad.setDireccionPersona(ciudad.getDireccionPersona());
                return ciudadesRepository.save(existingCiudad);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        ciudadesRepository.deleteById(id);
    }
}
