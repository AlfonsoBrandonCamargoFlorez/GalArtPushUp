package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.ICategorias;
import com.brandon.old.domain.entities.Categorias;
import com.brandon.old.infrastructure.repository.CategoriasRepository;

@Service
public class CategoriasService implements ICategorias {

    @Autowired
    private CategoriasRepository categoriasRepository;

    @Override
    public Optional<Categorias> findById(Long id) {
        return categoriasRepository.findById(id);
    }

    @Override
    public List<Categorias> getAll() {
        return categoriasRepository.findAll();
    }

    @Override
    public Categorias save(Categorias categorias) {
        return categoriasRepository.save(categorias);
    }

    @Override
    public Categorias update(Long id, Categorias categorias) {
        return categoriasRepository.findById(id)
            .map(existingCategorias -> {
                existingCategorias.setNombre(categorias.getNombre());
                return categoriasRepository.save(existingCategorias);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        categoriasRepository.deleteById(id);
    }
}
