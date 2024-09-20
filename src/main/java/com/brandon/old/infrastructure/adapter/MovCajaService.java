package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IMovCaja;
import com.brandon.old.domain.entities.MovCaja;
import com.brandon.old.infrastructure.repository.MovCajaRepository;

@Service
public class MovCajaService implements IMovCaja {

    @Autowired
    private MovCajaRepository movCajaRepository;

    @Override
    public Optional<MovCaja> findById(Long id) {
        return movCajaRepository.findById(id);
    }

    @Override
    public List<MovCaja> getAll() {
        return movCajaRepository.findAll();
    }

    @Override
    public MovCaja save(MovCaja movCaja) {
        return movCajaRepository.save(movCaja);
    }

    @Override
    public MovCaja update(Long id, MovCaja movCaja) {
        return movCajaRepository.findById(id)
            .map(existingMovCaja -> {
                existingMovCaja.setTipoMovimiento(movCaja.getTipoMovimiento());
                existingMovCaja.setMonto(movCaja.getMonto());
                existingMovCaja.setFechaMovimiento(movCaja.getFechaMovimiento());
                existingMovCaja.setEstacionPago(movCaja.getEstacionPago());
                existingMovCaja.setTipoMovCaja(movCaja.getTipoMovCaja());
                return movCajaRepository.save(existingMovCaja);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        movCajaRepository.deleteById(id);
    }
}
