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

import com.brandon.old.application.service.IDespachos;
import com.brandon.old.domain.entities.Despachos;

@RestController
@RequestMapping("/api/despachos")
public class DespachosController {

    @Autowired
    private IDespachos iDespachos;

    @GetMapping
    public List<Despachos> list() {
        return iDespachos.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despachos> show(@PathVariable Long id) {
        Optional<Despachos> despacho = iDespachos.findById(id);
        return despacho.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Despachos> createDespacho(@RequestBody Despachos despacho) {
        Despachos savedDespacho = iDespachos.save(despacho);
        return new ResponseEntity<>(savedDespacho, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despachos> updateDespacho(@PathVariable Long id, @RequestBody Despachos despacho) {
        Despachos updatedDespacho = iDespachos.update(id, despacho);
        return updatedDespacho != null ? new ResponseEntity<>(updatedDespacho, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDespacho(@PathVariable Long id) {
        if (iDespachos.findById(id).isPresent()) {
            iDespachos.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
