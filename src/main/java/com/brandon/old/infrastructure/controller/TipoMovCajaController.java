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

import com.brandon.old.application.service.ITipoMovCaja;
import com.brandon.old.domain.entities.TipoMovCaja;

@RestController
@RequestMapping("/api/tipos-mov-caja")
public class TipoMovCajaController {

    @Autowired
    private ITipoMovCaja iTipoMovCaja;

    @GetMapping
    public List<TipoMovCaja> list() {
        return iTipoMovCaja.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoMovCaja> show(@PathVariable Long id) {
        Optional<TipoMovCaja> tipoMovCaja = iTipoMovCaja.findById(id);
        return tipoMovCaja.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoMovCaja> createTipoMovCaja(@RequestBody TipoMovCaja tipoMovCaja) {
        TipoMovCaja savedTipoMovCaja = iTipoMovCaja.save(tipoMovCaja);
        return new ResponseEntity<>(savedTipoMovCaja, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoMovCaja> updateTipoMovCaja(@PathVariable Long id, @RequestBody TipoMovCaja tipoMovCaja) {
        TipoMovCaja updatedTipoMovCaja = iTipoMovCaja.update(id, tipoMovCaja);
        return updatedTipoMovCaja != null ? new ResponseEntity<>(updatedTipoMovCaja, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoMovCaja(@PathVariable Long id) {
        if (iTipoMovCaja.findById(id).isPresent()) {
            iTipoMovCaja.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
