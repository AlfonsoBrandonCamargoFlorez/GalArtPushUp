package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IClaseContacto;
import com.brandon.old.domain.entities.ClaseContacto;
import com.brandon.old.infrastructure.repository.ClaseContactoRepository;

@Service
public class ClaseContactoService implements IClaseContacto {

    @Autowired
    private ClaseContactoRepository claseContactoRepository;

    @Override
    public Optional<ClaseContacto> findById(Long id) {
        return claseContactoRepository.findById(id);
    }

    @Override
    public List<ClaseContacto> getAll() {
        return claseContactoRepository.findAll();
    }

    @Override
    public ClaseContacto save(ClaseContacto claseContacto) {
        return claseContactoRepository.save(claseContacto);
    }

    @Override
    public ClaseContacto update(Long id, ClaseContacto claseContacto) {
        return claseContactoRepository.findById(id)
            .map(existingClaseContacto -> {
                existingClaseContacto.setNombre(claseContacto.getNombre());
                return claseContactoRepository.save(existingClaseContacto);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        claseContactoRepository.deleteById(id);
    }
}
