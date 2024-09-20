package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.ITipoTransaccion;
import com.brandon.old.domain.entities.TipoTransaccion;
import com.brandon.old.infrastructure.repository.TipoTransaccionRepository;

@Service
public class TipoTransaccionService implements ITipoTransaccion {

    @Autowired
    private TipoTransaccionRepository tipoTransaccionRepository;

    @Override
    public Optional<TipoTransaccion> findById(Long id) {
        return tipoTransaccionRepository.findById(id);
    }

    @Override
    public List<TipoTransaccion> getAll() {
        return tipoTransaccionRepository.findAll();
    }

    @Override
    public TipoTransaccion save(TipoTransaccion tipoTransaccion) {
        return tipoTransaccionRepository.save(tipoTransaccion);
    }

    @Override
    public TipoTransaccion update(Long id, TipoTransaccion tipoTransaccion) {
        return tipoTransaccionRepository.findById(id)
            .map(existingTipoTransaccion -> {
                existingTipoTransaccion.setTipo(tipoTransaccion.getTipo());
                return tipoTransaccionRepository.save(existingTipoTransaccion);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        tipoTransaccionRepository.deleteById(id);
    }
}
