package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IPaises;
import com.brandon.old.domain.entities.Paises;
import com.brandon.old.infrastructure.repository.PaisesRepository;

@Service
public class PaisesService implements IPaises {

    @Autowired
    private PaisesRepository paisesRepository;

    @Override
    public Optional<Paises> findById(Long id) {
        return paisesRepository.findById(id);
    }

    @Override
    public List<Paises> getAll() {
        return paisesRepository.findAll();
    }

    @Override
    public Paises save(Paises paises) {
        return paisesRepository.save(paises);
    }

    @Override
    public Paises update(Long id, Paises paises) {
        return paisesRepository.findById(id)
            .map(existingPaises -> {
                existingPaises.setNombre(paises.getNombre());
                return paisesRepository.save(existingPaises);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        paisesRepository.deleteById(id);
    }
}
