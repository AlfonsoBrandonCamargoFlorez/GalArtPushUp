package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.RankingAntiguedad;

public interface IRankingAntiguedad {
    Optional<RankingAntiguedad> findById(Long id);
    List<RankingAntiguedad> getAll();
    RankingAntiguedad save(RankingAntiguedad categoria);
    RankingAntiguedad update(Long id, RankingAntiguedad categoria);
    void deleteById(Long id);

}
