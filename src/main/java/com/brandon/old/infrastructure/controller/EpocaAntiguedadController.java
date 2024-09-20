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

import com.brandon.old.application.service.IEpocaAntiguedad;
import com.brandon.old.domain.entities.EpocaAntiguedad;

@RestController
@RequestMapping("/api/epocas-antiguedad")
public class EpocaAntiguedadController {

    @Autowired
    private IEpocaAntiguedad iEpocaAntiguedad;

    @GetMapping
    public List<EpocaAntiguedad> list() {
        return iEpocaAntiguedad.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EpocaAntiguedad> show(@PathVariable Long id) {
        Optional<EpocaAntiguedad> epocaAntiguedad = iEpocaAntiguedad.findById(id);
        return epocaAntiguedad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EpocaAntiguedad> createEpocaAntiguedad(@RequestBody EpocaAntiguedad epocaAntiguedad) {
        EpocaAntiguedad savedEpocaAntiguedad = iEpocaAntiguedad.save(epocaAntiguedad);
        return new ResponseEntity<>(savedEpocaAntiguedad, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EpocaAntiguedad> updateEpocaAntiguedad(@PathVariable Long id, @RequestBody EpocaAntiguedad epocaAntiguedad) {
        EpocaAntiguedad updatedEpocaAntiguedad = iEpocaAntiguedad.update(id, epocaAntiguedad);
        return updatedEpocaAntiguedad != null ? new ResponseEntity<>(updatedEpocaAntiguedad, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpocaAntiguedad(@PathVariable Long id) {
        if (iEpocaAntiguedad.findById(id).isPresent()) {
            iEpocaAntiguedad.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
