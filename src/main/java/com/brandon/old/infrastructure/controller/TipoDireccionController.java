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

import com.brandon.old.application.service.ITipoDireccion;
import com.brandon.old.domain.entities.TipoDireccion;

@RestController
@RequestMapping("/api/tipos-direccion")
public class TipoDireccionController {

    @Autowired
    private ITipoDireccion iTipoDireccion;

    @GetMapping
    public List<TipoDireccion> list() {
        return iTipoDireccion.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDireccion> show(@PathVariable Long id) {
        Optional<TipoDireccion> tipoDireccion = iTipoDireccion.findById(id);
        return tipoDireccion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoDireccion> createTipoDireccion(@RequestBody TipoDireccion tipoDireccion) {
        TipoDireccion savedTipoDireccion = iTipoDireccion.save(tipoDireccion);
        return new ResponseEntity<>(savedTipoDireccion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDireccion> updateTipoDireccion(@PathVariable Long id, @RequestBody TipoDireccion tipoDireccion) {
        TipoDireccion updatedTipoDireccion = iTipoDireccion.update(id, tipoDireccion);
        return updatedTipoDireccion != null ? new ResponseEntity<>(updatedTipoDireccion, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoDireccion(@PathVariable Long id) {
        if (iTipoDireccion.findById(id).isPresent()) {
            iTipoDireccion.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
