package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IMedioPago;
import com.brandon.old.domain.entities.MedioPago;
import com.brandon.old.infrastructure.repository.MedioPagoRepository;

@Service
public class MedioPagoService implements IMedioPago {

    @Autowired
    private MedioPagoRepository medioPagoRepository;

    @Override
    public Optional<MedioPago> findById(Long id) {
        return medioPagoRepository.findById(id);
    }

    @Override
    public List<MedioPago> getAll() {
        return medioPagoRepository.findAll();
    }

    @Override
    public MedioPago save(MedioPago medioPago) {
        return medioPagoRepository.save(medioPago);
    }

    @Override
    public MedioPago update(Long id, MedioPago medioPago) {
        return medioPagoRepository.findById(id)
            .map(existingMedioPago -> {
                existingMedioPago.setTipo(medioPago.getTipo());
                return medioPagoRepository.save(existingMedioPago);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        medioPagoRepository.deleteById(id);
    }
}
