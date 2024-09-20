package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.ITipoMovCaja;
import com.brandon.old.domain.entities.TipoMovCaja;
import com.brandon.old.infrastructure.repository.TipoMovCajaRepository;

@Service
public class TipoMovCajaService implements ITipoMovCaja {

    @Autowired
    private TipoMovCajaRepository tipoMovCajaRepository;

    @Override
    public Optional<TipoMovCaja> findById(Long id) {
        return tipoMovCajaRepository.findById(id);
    }

    @Override
    public List<TipoMovCaja> getAll() {
        return tipoMovCajaRepository.findAll();
    }

    @Override
    public TipoMovCaja save(TipoMovCaja tipoMovCaja) {
        return tipoMovCajaRepository.save(tipoMovCaja);
    }

    @Override
    public TipoMovCaja update(Long id, TipoMovCaja tipoMovCaja) {
        return tipoMovCajaRepository.findById(id)
            .map(existingTipoMovCaja -> {
                existingTipoMovCaja.setTipo(tipoMovCaja.getTipo());
                return tipoMovCajaRepository.save(existingTipoMovCaja);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        tipoMovCajaRepository.deleteById(id);
    }
}
