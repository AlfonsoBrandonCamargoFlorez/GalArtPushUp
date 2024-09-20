package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IGaleria;
import com.brandon.old.domain.entities.Galeria;
import com.brandon.old.infrastructure.repository.GaleriaRepository;

@Service
public class GaleriaService implements IGaleria {

    @Autowired
    private GaleriaRepository galeriaRepository;

    @Override
    public Optional<Galeria> findById(Long id) {
        return galeriaRepository.findById(id);
    }

    @Override
    public List<Galeria> getAll() {
        return galeriaRepository.findAll();
    }

    @Override
    public Galeria save(Galeria galeria) {
        return galeriaRepository.save(galeria);
    }

    @Override
    public Galeria update(Long id, Galeria galeria) {
        return galeriaRepository.findById(id)
            .map(existingGaleria -> {
                existingGaleria.setUrlImagen(galeria.getUrlImagen());
                existingGaleria.setDescripcion(galeria.getDescripcion());
                existingGaleria.setAntiguedades(galeria.getAntiguedades());
                return galeriaRepository.save(existingGaleria);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        galeriaRepository.deleteById(id);
    }
}
