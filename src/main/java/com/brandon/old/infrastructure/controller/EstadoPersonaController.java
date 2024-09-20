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

import com.brandon.old.application.service.IEstadoPersona;
import com.brandon.old.domain.entities.EstadoPersona;

@RestController
@RequestMapping("/api/estados-persona")
public class EstadoPersonaController {

    @Autowired
    private IEstadoPersona iEstadoPersona;

    @GetMapping
    public List<EstadoPersona> list() {
        return iEstadoPersona.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoPersona> show(@PathVariable Long id) {
        Optional<EstadoPersona> estadoPersona = iEstadoPersona.findById(id);
        return estadoPersona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadoPersona> createEstadoPersona(@RequestBody EstadoPersona estadoPersona) {
        EstadoPersona savedEstadoPersona = iEstadoPersona.save(estadoPersona);
        return new ResponseEntity<>(savedEstadoPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoPersona> updateEstadoPersona(@PathVariable Long id, @RequestBody EstadoPersona estadoPersona) {
        EstadoPersona updatedEstadoPersona = iEstadoPersona.update(id, estadoPersona);
        return updatedEstadoPersona != null ? new ResponseEntity<>(updatedEstadoPersona, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadoPersona(@PathVariable Long id) {
        if (iEstadoPersona.findById(id).isPresent()) {
            iEstadoPersona.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
