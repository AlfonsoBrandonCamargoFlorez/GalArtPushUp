package com.brandon.old.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.brandon.old.application.service.ITransacciones;
import com.brandon.old.domain.entities.Transacciones;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionesController {

    @Autowired
    private ITransacciones iTransacciones;

    @GetMapping
    public List<Transacciones> list() {
        return iTransacciones.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacciones> show(@PathVariable Long id) {
        Optional<Transacciones> transaccion = iTransacciones.findById(id);
        return transaccion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Transacciones> createTransaccion(@RequestBody Transacciones transaccion) {
        Transacciones savedTransaccion = iTransacciones.save(transaccion);
        return new ResponseEntity<>(savedTransaccion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacciones> updateTransaccion(@PathVariable Long id, @RequestBody Transacciones transaccion) {
        Transacciones updatedTransaccion = iTransacciones.update(id, transaccion);
        return updatedTransaccion != null ? new ResponseEntity<>(updatedTransaccion, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaccion(@PathVariable Long id) {
        if (iTransacciones.findById(id).isPresent()) {
            iTransacciones.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
