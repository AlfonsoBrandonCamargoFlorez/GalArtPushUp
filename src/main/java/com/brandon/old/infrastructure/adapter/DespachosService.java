package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IDespachos;
import com.brandon.old.domain.entities.Despachos;
import com.brandon.old.infrastructure.repository.DespachosRepository;

@Service
public class DespachosService implements IDespachos {

    @Autowired
    private DespachosRepository despachosRepository;

    @Override
    public Optional<Despachos> findById(Long id) {
        return despachosRepository.findById(id);
    }

    @Override
    public List<Despachos> getAll() {
        return despachosRepository.findAll();
    }

    @Override
    public Despachos save(Despachos despachos) {
        return despachosRepository.save(despachos);
    }

    @Override
    public Despachos update(Long id, Despachos despachos) {
        return despachosRepository.findById(id)
            .map(existingDespacho -> {
                existingDespacho.setEstado(despachos.getEstado());
                existingDespacho.setTransacciones(despachos.getTransacciones());
                return despachosRepository.save(existingDespacho);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        despachosRepository.deleteById(id);
    }
}
