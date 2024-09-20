package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IEstacionPago;
import com.brandon.old.domain.entities.EstacionPago;
import com.brandon.old.infrastructure.repository.EstacionPagoRepository;

@Service
public class EstacionPagoService implements IEstacionPago {

    @Autowired
    private EstacionPagoRepository estacionPagoRepository;

    @Override
    public Optional<EstacionPago> findById(Long id) {
        return estacionPagoRepository.findById(id);
    }

    @Override
    public List<EstacionPago> getAll() {
        return estacionPagoRepository.findAll();
    }

    @Override
    public EstacionPago save(EstacionPago estacionPago) {
        return estacionPagoRepository.save(estacionPago);
    }

    @Override
    public EstacionPago update(Long id, EstacionPago estacionPago) {
        return estacionPagoRepository.findById(id)
            .map(existingEstacion -> {
                existingEstacion.setNombre(estacionPago.getNombre());
                existingEstacion.setUbicacion(estacionPago.getUbicacion());
                return estacionPagoRepository.save(existingEstacion);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        estacionPagoRepository.deleteById(id);
    }
}
