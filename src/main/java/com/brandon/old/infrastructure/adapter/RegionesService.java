package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IRegiones;
import com.brandon.old.domain.entities.Regiones;
import com.brandon.old.infrastructure.repository.RegionesRepository;

@Service
public class RegionesService implements IRegiones {

    @Autowired
    private RegionesRepository regionesRepository;

    @Override
    public Optional<Regiones> findById(Long id) {
        return regionesRepository.findById(id);
    }

    @Override
    public List<Regiones> getAll() {
        return regionesRepository.findAll();
    }

    @Override
    public Regiones save(Regiones regiones) {
        return regionesRepository.save(regiones);
    }

    @Override
    public Regiones update(Long id, Regiones regiones) {
        return regionesRepository.findById(id)
            .map(existingRegiones -> {
                existingRegiones.setNombre(regiones.getNombre());
                existingRegiones.setPaises(regiones.getPaises());
                return regionesRepository.save(existingRegiones);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        regionesRepository.deleteById(id);
    }
}
