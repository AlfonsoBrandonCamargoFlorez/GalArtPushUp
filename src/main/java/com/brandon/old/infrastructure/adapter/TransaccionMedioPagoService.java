package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.ITransaccionMedioPago;
import com.brandon.old.domain.entities.TransaccionMedioPago;
import com.brandon.old.infrastructure.repository.TransaccionMedioPagoRepository;

@Service
public class TransaccionMedioPagoService implements ITransaccionMedioPago {

    @Autowired
    private TransaccionMedioPagoRepository transaccionMedioPagoRepository;

    @Override
    public Optional<TransaccionMedioPago> findById(Long id) {
        return transaccionMedioPagoRepository.findById(id);
    }

    @Override
    public List<TransaccionMedioPago> getAll() {
        return transaccionMedioPagoRepository.findAll();
    }

    @Override
    public TransaccionMedioPago save(TransaccionMedioPago transaccionMedioPago) {
        return transaccionMedioPagoRepository.save(transaccionMedioPago);
    }

    @Override
    public TransaccionMedioPago update(Long id, TransaccionMedioPago transaccionMedioPago) {
        return transaccionMedioPagoRepository.findById(id)
            .map(existingTransaccionMedioPago -> {
                existingTransaccionMedioPago.setMedioPago(transaccionMedioPago.getMedioPago());
                existingTransaccionMedioPago.setTransaccion(transaccionMedioPago.getTransaccion());
                return transaccionMedioPagoRepository.save(existingTransaccionMedioPago);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        transaccionMedioPagoRepository.deleteById(id);
    }
}
