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

import com.brandon.old.application.service.IEstacionPago;
import com.brandon.old.domain.entities.EstacionPago;

@RestController
@RequestMapping("/api/estaciones-pago")
public class EstacionPagoController {

    @Autowired
    private IEstacionPago iEstacionPago;

    @GetMapping
    public List<EstacionPago> list() {
        return iEstacionPago.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstacionPago> show(@PathVariable Long id) {
        Optional<EstacionPago> estacionPago = iEstacionPago.findById(id);
        return estacionPago.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstacionPago> createEstacionPago(@RequestBody EstacionPago estacionPago) {
        EstacionPago savedEstacionPago = iEstacionPago.save(estacionPago);
        return new ResponseEntity<>(savedEstacionPago, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstacionPago> updateEstacionPago(@PathVariable Long id, @RequestBody EstacionPago estacionPago) {
        EstacionPago updatedEstacionPago = iEstacionPago.update(id, estacionPago);
        return updatedEstacionPago != null ? new ResponseEntity<>(updatedEstacionPago, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstacionPago(@PathVariable Long id) {
        if (iEstacionPago.findById(id).isPresent()) {
            iEstacionPago.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
