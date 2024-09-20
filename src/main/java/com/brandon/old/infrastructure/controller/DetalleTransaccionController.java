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

import com.brandon.old.application.service.IDetalleTransaccion;
import com.brandon.old.domain.entities.DetalleTransaccion;

@RestController
@RequestMapping("/api/detalle-transacciones")
public class DetalleTransaccionController {

    @Autowired
    private IDetalleTransaccion iDetalleTransaccion;

    @GetMapping
    public List<DetalleTransaccion> list() {
        return iDetalleTransaccion.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleTransaccion> show(@PathVariable Long id) {
        Optional<DetalleTransaccion> detalleTransaccion = iDetalleTransaccion.findById(id);
        return detalleTransaccion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DetalleTransaccion> createDetalleTransaccion(@RequestBody DetalleTransaccion detalleTransaccion) {
        DetalleTransaccion savedDetalleTransaccion = iDetalleTransaccion.save(detalleTransaccion);
        return new ResponseEntity<>(savedDetalleTransaccion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleTransaccion> updateDetalleTransaccion(@PathVariable Long id, @RequestBody DetalleTransaccion detalleTransaccion) {
        DetalleTransaccion updatedDetalleTransaccion = iDetalleTransaccion.update(id, detalleTransaccion);
        return updatedDetalleTransaccion != null ? new ResponseEntity<>(updatedDetalleTransaccion, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleTransaccion(@PathVariable Long id) {
        if (iDetalleTransaccion.findById(id).isPresent()) {
            iDetalleTransaccion.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
