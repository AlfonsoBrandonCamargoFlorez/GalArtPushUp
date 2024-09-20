package com.brandon.old.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandon.old.application.service.IRankingAntiguedad;
import com.brandon.old.domain.entities.RankingAntiguedad;

@RestController
@RequestMapping("/api/ranking-antiguedades")
public class RankingAntiguedadController {

    @Autowired
    private IRankingAntiguedad iRankingAntiguedad;

    @GetMapping
    public List<RankingAntiguedad> list() {
        return iRankingAntiguedad.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RankingAntiguedad> show(@PathVariable Long id) {
        Optional<RankingAntiguedad> rankingAntiguedad = iRankingAntiguedad.findById(id);
        return rankingAntiguedad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RankingAntiguedad> createRankingAntiguedad(@RequestBody RankingAntiguedad rankingAntiguedad) {
        RankingAntiguedad savedRanking = iRankingAntiguedad.save(rankingAntiguedad);
        return new ResponseEntity<>(savedRanking, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RankingAntiguedad> updateRankingAntiguedad(@PathVariable Long id, @RequestBody RankingAntiguedad rankingAntiguedad) {
        RankingAntiguedad updatedRanking = iRankingAntiguedad.update(id, rankingAntiguedad);
        return updatedRanking != null ? new ResponseEntity<>(updatedRanking, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRankingAntiguedad(@PathVariable Long id) {
        if (iRankingAntiguedad.findById(id).isPresent()) {
            iRankingAntiguedad.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
