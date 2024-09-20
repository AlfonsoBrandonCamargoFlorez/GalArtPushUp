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

import com.brandon.old.application.service.IDireccionPersona;
import com.brandon.old.domain.entities.DireccionPersona;

@RestController
@RequestMapping("/api/direccion-personas")
public class DireccionPersonaController {

    @Autowired
    private IDireccionPersona iDireccionPersona;

    @GetMapping
    public List<DireccionPersona> list() {
        return iDireccionPersona.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionPersona> show(@PathVariable Long id) {
        Optional<DireccionPersona> direccionPersona = iDireccionPersona.findById(id);
        return direccionPersona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DireccionPersona> createDireccionPersona(@RequestBody DireccionPersona direccionPersona) {
        DireccionPersona savedDireccionPersona = iDireccionPersona.save(direccionPersona);
        return new ResponseEntity<>(savedDireccionPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DireccionPersona> updateDireccionPersona(@PathVariable Long id, @RequestBody DireccionPersona direccionPersona) {
        DireccionPersona updatedDireccionPersona = iDireccionPersona.update(id, direccionPersona);
        return updatedDireccionPersona != null ? new ResponseEntity<>(updatedDireccionPersona, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDireccionPersona(@PathVariable Long id) {
        if (iDireccionPersona.findById(id).isPresent()) {
            iDireccionPersona.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
