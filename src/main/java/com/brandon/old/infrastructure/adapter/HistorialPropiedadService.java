package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IHistorialPropiedad;
import com.brandon.old.domain.entities.HistorialPropiedad;
import com.brandon.old.infrastructure.repository.HistorialPropiedadRepository;

@Service
public class HistorialPropiedadService implements IHistorialPropiedad {

    @Autowired
    private HistorialPropiedadRepository historialPropiedadRepository;

    @Override
    public Optional<HistorialPropiedad> findById(Long id) {
        return historialPropiedadRepository.findById(id);
    }

    @Override
    public List<HistorialPropiedad> getAll() {
        return historialPropiedadRepository.findAll();
    }

    @Override
    public HistorialPropiedad save(HistorialPropiedad historialPropiedad) {
        return historialPropiedadRepository.save(historialPropiedad);
    }

    @Override
    public HistorialPropiedad update(Long id, HistorialPropiedad historialPropiedad) {
        return historialPropiedadRepository.findById(id)
            .map(existingHistorial -> {
                existingHistorial.setAntiguedades(historialPropiedad.getAntiguedades());
                existingHistorial.setFechaMovimiento(historialPropiedad.getFechaMovimiento());
                existingHistorial.setNuevoPropietario(historialPropiedad.getNuevoPropietario());
                existingHistorial.setAnteriorPropietario(historialPropiedad.getAnteriorPropietario());
                return historialPropiedadRepository.save(existingHistorial);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        historialPropiedadRepository.deleteById(id);
    }
}
