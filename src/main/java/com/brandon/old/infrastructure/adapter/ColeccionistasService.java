package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IColeccionistas;
import com.brandon.old.domain.entities.Coleccionistas;
import com.brandon.old.infrastructure.repository.ColeccionistasRepository;

@Service
public class ColeccionistasService implements IColeccionistas {

    @Autowired
    private ColeccionistasRepository coleccionistasRepository;

    @Override
    public Optional<Coleccionistas> findById(Long id) {
        return coleccionistasRepository.findById(id);
    }

    @Override
    public List<Coleccionistas> getAll() {
        return coleccionistasRepository.findAll();
    }

    @Override
    public Coleccionistas save(Coleccionistas coleccionista) {
        return coleccionistasRepository.save(coleccionista);
    }

    @Override
    public Coleccionistas update(Long id, Coleccionistas coleccionista) {
        return coleccionistasRepository.findById(id)
            .map(existingColeccionista -> {
                existingColeccionista.setPersona(coleccionista.getPersona());
                return coleccionistasRepository.save(existingColeccionista);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        coleccionistasRepository.deleteById(id);
    }
}
