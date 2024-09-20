package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.EpocaAntiguedad;

public interface IEpocaAntiguedad {
    Optional<EpocaAntiguedad> findById(Long id);
    List<EpocaAntiguedad> getAll();
    EpocaAntiguedad save(EpocaAntiguedad categoria);
    EpocaAntiguedad update(Long id, EpocaAntiguedad categoria);
    void deleteById(Long id);

}
