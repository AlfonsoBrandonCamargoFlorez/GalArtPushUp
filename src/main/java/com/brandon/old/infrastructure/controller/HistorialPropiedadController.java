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

import com.brandon.old.application.service.IHistorialPropiedad;
import com.brandon.old.domain.entities.HistorialPropiedad;

@RestController
@RequestMapping("/api/historial-propiedades")
public class HistorialPropiedadController {

    @Autowired
    private IHistorialPropiedad iHistorialPropiedad;

    @GetMapping
    public List<HistorialPropiedad> list() {
        return iHistorialPropiedad.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialPropiedad> show(@PathVariable Long id) {
        Optional<HistorialPropiedad> historial = iHistorialPropiedad.findById(id);
        return historial.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HistorialPropiedad> createHistorial(@RequestBody HistorialPropiedad historialPropiedad) {
        HistorialPropiedad savedHistorial = iHistorialPropiedad.save(historialPropiedad);
        return new ResponseEntity<>(savedHistorial, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialPropiedad> updateHistorial(@PathVariable Long id, @RequestBody HistorialPropiedad historialPropiedad) {
        HistorialPropiedad updatedHistorial = iHistorialPropiedad.update(id, historialPropiedad);
        return updatedHistorial != null ? new ResponseEntity<>(updatedHistorial, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistorial(@PathVariable Long id) {
        if (iHistorialPropiedad.findById(id).isPresent()) {
            iHistorialPropiedad.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
