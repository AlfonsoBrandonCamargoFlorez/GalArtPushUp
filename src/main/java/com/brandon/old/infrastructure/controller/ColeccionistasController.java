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

import com.brandon.old.application.service.IColeccionistas;
import com.brandon.old.domain.entities.Coleccionistas;

@RestController
@RequestMapping("/api/coleccionistas")
public class ColeccionistasController {

    @Autowired
    private IColeccionistas iColeccionistas;

    @GetMapping
    public List<Coleccionistas> list() {
        return iColeccionistas.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coleccionistas> show(@PathVariable Long id) {
        Optional<Coleccionistas> coleccionista = iColeccionistas.findById(id);
        return coleccionista.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Coleccionistas> createColeccionista(@RequestBody Coleccionistas coleccionista) {
        Coleccionistas savedColeccionista = iColeccionistas.save(coleccionista);
        return new ResponseEntity<>(savedColeccionista, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coleccionistas> updateColeccionista(@PathVariable Long id, @RequestBody Coleccionistas coleccionista) {
        Coleccionistas updatedColeccionista = iColeccionistas.update(id, coleccionista);
        return updatedColeccionista != null ? new ResponseEntity<>(updatedColeccionista, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColeccionista(@PathVariable Long id) {
        if (iColeccionistas.findById(id).isPresent()) {
            iColeccionistas.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
