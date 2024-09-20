package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IDireccionPersona;
import com.brandon.old.domain.entities.DireccionPersona;
import com.brandon.old.infrastructure.repository.DireccionPersonaRepository;

@Service
public class DireccionPersonaService implements IDireccionPersona {

    @Autowired
    private DireccionPersonaRepository direccionPersonaRepository;

    @Override
    public Optional<DireccionPersona> findById(Long id) {
        return direccionPersonaRepository.findById(id);
    }

    @Override
    public List<DireccionPersona> getAll() {
        return direccionPersonaRepository.findAll();
    }

    @Override
    public DireccionPersona save(DireccionPersona direccionPersona) {
        return direccionPersonaRepository.save(direccionPersona);
    }

    @Override
    public DireccionPersona update(Long id, DireccionPersona direccionPersona) {
        return direccionPersonaRepository.findById(id)
            .map(existingDireccion -> {
                existingDireccion.setDireccion(direccionPersona.getDireccion());
                existingDireccion.setTipoDireccion(direccionPersona.getTipoDireccion());
                existingDireccion.setPersona(direccionPersona.getPersona());
                return direccionPersonaRepository.save(existingDireccion);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        direccionPersonaRepository.deleteById(id);
    }
}
