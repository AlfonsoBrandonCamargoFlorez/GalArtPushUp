package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IAntiguedades;
import com.brandon.old.domain.entities.Antiguedades;
import com.brandon.old.infrastructure.repository.AntiguedadesRepository;

@Service
public class AntiguedadesService implements IAntiguedades {

    @Autowired
    private AntiguedadesRepository antiguedadesRepository;

    @Override
    public Optional<Antiguedades> findById(Long id) {
        return antiguedadesRepository.findById(id);
    }

    @Override
    public List<Antiguedades> getAll() {
        return antiguedadesRepository.findAll();
    }

    @Override
    public Antiguedades save(Antiguedades antiguedades) {
        return antiguedadesRepository.save(antiguedades);
    }

    @Override
    public Antiguedades update(Long id, Antiguedades antiguedades) {
        return antiguedadesRepository.findById(id)
            .map(existingAntiguedades -> {
                existingAntiguedades.setNombre(antiguedades.getNombre());
                existingAntiguedades.setDescripcion(antiguedades.getDescripcion());
                existingAntiguedades.setPrecio(antiguedades.getPrecio());
                existingAntiguedades.setEstadoConservacion(antiguedades.getEstadoConservacion());
                existingAntiguedades.setFechaMovimiento(antiguedades.getFechaMovimiento());
                existingAntiguedades.setEpocaAntiguedad(antiguedades.getEpocaAntiguedad());
                existingAntiguedades.setCategorias(antiguedades.getCategorias());
                existingAntiguedades.setSucursal(antiguedades.getSucursal());
                return antiguedadesRepository.save(existingAntiguedades);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        antiguedadesRepository.deleteById(id);
    }
}
