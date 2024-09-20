package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IDetalleTransaccion;
import com.brandon.old.domain.entities.DetalleTransaccion;
import com.brandon.old.infrastructure.repository.DetalleTransaccionRepository;

@Service
public class DetalleTransaccionService implements IDetalleTransaccion {

    @Autowired
    private DetalleTransaccionRepository detalleTransaccionRepository;

    @Override
    public Optional<DetalleTransaccion> findById(Long id) {
        return detalleTransaccionRepository.findById(id);
    }

    @Override
    public List<DetalleTransaccion> getAll() {
        return detalleTransaccionRepository.findAll();
    }

    @Override
    public DetalleTransaccion save(DetalleTransaccion detalleTransaccion) {
        return detalleTransaccionRepository.save(detalleTransaccion);
    }

    @Override
    public DetalleTransaccion update(Long id, DetalleTransaccion detalleTransaccion) {
        return detalleTransaccionRepository.findById(id)
            .map(existingDetalle -> {
                existingDetalle.setAntiguedades(detalleTransaccion.getAntiguedades());
                existingDetalle.setTransacciones(detalleTransaccion.getTransacciones());
                return detalleTransaccionRepository.save(existingDetalle);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        detalleTransaccionRepository.deleteById(id);
    }
}
