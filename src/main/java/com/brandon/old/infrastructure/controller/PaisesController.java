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

import com.brandon.old.application.service.IPaises;
import com.brandon.old.domain.entities.Paises;

@RestController
@RequestMapping("/api/paises")
public class PaisesController {

    @Autowired
    private IPaises iPaises;

    @GetMapping
    public List<Paises> list() {
        return iPaises.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paises> show(@PathVariable Long id) {
        Optional<Paises> pais = iPaises.findById(id);
        return pais.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Paises> createPais(@RequestBody Paises pais) {
        Paises savedPais = iPaises.save(pais);
        return new ResponseEntity<>(savedPais, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paises> updatePais(@PathVariable Long id, @RequestBody Paises pais) {
        Paises updatedPais = iPaises.update(id, pais);
        return updatedPais != null ? new ResponseEntity<>(updatedPais, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable Long id) {
        if (iPaises.findById(id).isPresent()) {
            iPaises.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
