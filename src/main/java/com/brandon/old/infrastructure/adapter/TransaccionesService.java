package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.ITransacciones;
import com.brandon.old.domain.entities.Transacciones;
import com.brandon.old.infrastructure.repository.TransaccionesRepository;

@Service
public class TransaccionesService implements ITransacciones {

    @Autowired
    private TransaccionesRepository transaccionesRepository;

    @Override
    public Optional<Transacciones> findById(Long id) {
        return transaccionesRepository.findById(id);
    }

    @Override
    public List<Transacciones> getAll() {
        return transaccionesRepository.findAll();
    }

    @Override
    public Transacciones save(Transacciones transacciones) {
        return transaccionesRepository.save(transacciones);
    }

    @Override
    public Transacciones update(Long id, Transacciones transacciones) {
        return transaccionesRepository.findById(id)
            .map(existingTransacciones -> {
                existingTransacciones.setMonto(transacciones.getMonto());
                existingTransacciones.setFecha(transacciones.getFecha());
                existingTransacciones.setTipoTransaccion(transacciones.getTipoTransaccion());
                existingTransacciones.setComprador(transacciones.getComprador());
                existingTransacciones.setVendedor(transacciones.getVendedor());
                existingTransacciones.setEstacionPago(transacciones.getEstacionPago());
                return transaccionesRepository.save(existingTransacciones);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        transaccionesRepository.deleteById(id);
    }
}
