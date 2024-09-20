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

import com.brandon.old.application.service.IRegiones;
import com.brandon.old.domain.entities.Regiones;

@RestController
@RequestMapping("/api/regiones")
public class RegionesController {

    @Autowired
    private IRegiones iRegiones;

    @GetMapping
    public List<Regiones> list() {
        return iRegiones.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Regiones> show(@PathVariable Long id) {
        Optional<Regiones> regiones = iRegiones.findById(id);
        return regiones.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Regiones> createRegiones(@RequestBody Regiones regiones) {
        Regiones savedRegiones = iRegiones.save(regiones);
        return new ResponseEntity<>(savedRegiones, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Regiones> updateRegiones(@PathVariable Long id, @RequestBody Regiones regiones) {
        Regiones updatedRegiones = iRegiones.update(id, regiones);
        return updatedRegiones != null ? new ResponseEntity<>(updatedRegiones, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegiones(@PathVariable Long id) {
        if (iRegiones.findById(id).isPresent()) {
            iRegiones.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
