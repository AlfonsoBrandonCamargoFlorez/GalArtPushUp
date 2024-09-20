package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IEpocaAntiguedad;
import com.brandon.old.domain.entities.EpocaAntiguedad;
import com.brandon.old.infrastructure.repository.EpocaAntiguedadRepository;

@Service
public class EpocaAntiguedadService implements IEpocaAntiguedad {

    @Autowired
    private EpocaAntiguedadRepository epocaAntiguedadRepository;

    @Override
    public Optional<EpocaAntiguedad> findById(Long id) {
        return epocaAntiguedadRepository.findById(id);
    }

    @Override
    public List<EpocaAntiguedad> getAll() {
        return epocaAntiguedadRepository.findAll();
    }

    @Override
    public EpocaAntiguedad save(EpocaAntiguedad epocaAntiguedad) {
        return epocaAntiguedadRepository.save(epocaAntiguedad);
    }

    @Override
    public EpocaAntiguedad update(Long id, EpocaAntiguedad epocaAntiguedad) {
        return epocaAntiguedadRepository.findById(id)
            .map(existingEpoca -> {
                existingEpoca.setNombre(epocaAntiguedad.getNombre());
                return epocaAntiguedadRepository.save(existingEpoca);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        epocaAntiguedadRepository.deleteById(id);
    }
}
