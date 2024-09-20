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

import com.brandon.old.application.service.IGaleria;
import com.brandon.old.domain.entities.Galeria;

@RestController
@RequestMapping("/api/galerias")
public class GaleriaController {

    @Autowired
    private IGaleria iGaleria;

    @GetMapping
    public List<Galeria> list() {
        return iGaleria.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Galeria> show(@PathVariable Long id) {
        Optional<Galeria> galeria = iGaleria.findById(id);
        return galeria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Galeria> createGaleria(@RequestBody Galeria galeria) {
        Galeria savedGaleria = iGaleria.save(galeria);
        return new ResponseEntity<>(savedGaleria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Galeria> updateGaleria(@PathVariable Long id, @RequestBody Galeria galeria) {
        Galeria updatedGaleria = iGaleria.update(id, galeria);
        return updatedGaleria != null ? new ResponseEntity<>(updatedGaleria, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGaleria(@PathVariable Long id) {
        if (iGaleria.findById(id).isPresent()) {
            iGaleria.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
