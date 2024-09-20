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

import com.brandon.old.application.service.IMedioPago;
import com.brandon.old.domain.entities.MedioPago;

@RestController
@RequestMapping("/api/medio-pagos")
public class MedioPagoController {

    @Autowired
    private IMedioPago iMedioPago;

    @GetMapping
    public List<MedioPago> list() {
        return iMedioPago.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedioPago> show(@PathVariable Long id) {
        Optional<MedioPago> medioPago = iMedioPago.findById(id);
        return medioPago.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MedioPago> createMedioPago(@RequestBody MedioPago medioPago) {
        MedioPago savedMedioPago = iMedioPago.save(medioPago);
        return new ResponseEntity<>(savedMedioPago, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedioPago> updateMedioPago(@PathVariable Long id, @RequestBody MedioPago medioPago) {
        MedioPago updatedMedioPago = iMedioPago.update(id, medioPago);
        return updatedMedioPago != null ? new ResponseEntity<>(updatedMedioPago, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedioPago(@PathVariable Long id) {
        if (iMedioPago.findById(id).isPresent()) {
            iMedioPago.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
