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

import com.brandon.old.application.service.ITipoPersona;
import com.brandon.old.domain.entities.TipoPersona;

@RestController
@RequestMapping("/api/tipos-persona")
public class TipoPersonaController {

    @Autowired
    private ITipoPersona iTipoPersona;

    @GetMapping
    public List<TipoPersona> list() {
        return iTipoPersona.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPersona> show(@PathVariable Long id) {
        Optional<TipoPersona> tipoPersona = iTipoPersona.findById(id);
        return tipoPersona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoPersona> createTipoPersona(@RequestBody TipoPersona tipoPersona) {
        TipoPersona savedTipoPersona = iTipoPersona.save(tipoPersona);
        return new ResponseEntity<>(savedTipoPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPersona> updateTipoPersona(@PathVariable Long id, @RequestBody TipoPersona tipoPersona) {
        TipoPersona updatedTipoPersona = iTipoPersona.update(id, tipoPersona);
        return updatedTipoPersona != null ? new ResponseEntity<>(updatedTipoPersona, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoPersona(@PathVariable Long id) {
        if (iTipoPersona.findById(id).isPresent()) {
            iTipoPersona.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
