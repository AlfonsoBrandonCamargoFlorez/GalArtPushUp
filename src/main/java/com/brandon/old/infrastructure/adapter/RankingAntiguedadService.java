package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IRankingAntiguedad;
import com.brandon.old.domain.entities.RankingAntiguedad;
import com.brandon.old.infrastructure.repository.RankingAntiguedadRepository;

@Service
public class RankingAntiguedadService implements IRankingAntiguedad {

    @Autowired
    private RankingAntiguedadRepository rankingAntiguedadRepository;

    @Override
    public Optional<RankingAntiguedad> findById(Long id) {
        return rankingAntiguedadRepository.findById(id);
    }

    @Override
    public List<RankingAntiguedad> getAll() {
        return rankingAntiguedadRepository.findAll();
    }

    @Override
    public RankingAntiguedad save(RankingAntiguedad rankingAntiguedad) {
        return rankingAntiguedadRepository.save(rankingAntiguedad);
    }

    @Override
    public RankingAntiguedad update(Long id, RankingAntiguedad rankingAntiguedad) {
        return rankingAntiguedadRepository.findById(id)
            .map(existingRanking -> {
                existingRanking.setNombre(rankingAntiguedad.getNombre());
                existingRanking.setAntiguedades(rankingAntiguedad.getAntiguedades());
                return rankingAntiguedadRepository.save(existingRanking);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        rankingAntiguedadRepository.deleteById(id);
    }
}
