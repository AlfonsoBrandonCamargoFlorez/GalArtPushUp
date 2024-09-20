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

import com.brandon.old.application.service.IMovCaja;
import com.brandon.old.domain.entities.MovCaja;

@RestController
@RequestMapping("/api/mov-cajas")
public class MovCajaController {

    @Autowired
    private IMovCaja iMovCaja;

    @GetMapping
    public List<MovCaja> list() {
        return iMovCaja.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovCaja> show(@PathVariable Long id) {
        Optional<MovCaja> movCaja = iMovCaja.findById(id);
        return movCaja.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MovCaja> createMovCaja(@RequestBody MovCaja movCaja) {
        MovCaja savedMovCaja = iMovCaja.save(movCaja);
        return new ResponseEntity<>(savedMovCaja, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovCaja> updateMovCaja(@PathVariable Long id, @RequestBody MovCaja movCaja) {
        MovCaja updatedMovCaja = iMovCaja.update(id, movCaja);
        return updatedMovCaja != null ? new ResponseEntity<>(updatedMovCaja, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovCaja(@PathVariable Long id) {
        if (iMovCaja.findById(id).isPresent()) {
            iMovCaja.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
