package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.ITipoDireccion;
import com.brandon.old.domain.entities.TipoDireccion;
import com.brandon.old.infrastructure.repository.TipoDireccionRepository;

@Service
public class TipoDireccionService implements ITipoDireccion {

    @Autowired
    private TipoDireccionRepository tipoDireccionRepository;

    @Override
    public Optional<TipoDireccion> findById(Long id) {
        return tipoDireccionRepository.findById(id);
    }

    @Override
    public List<TipoDireccion> getAll() {
        return tipoDireccionRepository.findAll();
    }

    @Override
    public TipoDireccion save(TipoDireccion tipoDireccion) {
        return tipoDireccionRepository.save(tipoDireccion);
    }

    @Override
    public TipoDireccion update(Long id, TipoDireccion tipoDireccion) {
        return tipoDireccionRepository.findById(id)
            .map(existingTipoDireccion -> {
                existingTipoDireccion.setTipo(tipoDireccion.getTipo());
                return tipoDireccionRepository.save(existingTipoDireccion);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        tipoDireccionRepository.deleteById(id);
    }
}
