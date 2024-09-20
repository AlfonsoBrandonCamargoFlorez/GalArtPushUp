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

import com.brandon.old.application.service.ICiudades;
import com.brandon.old.domain.entities.Ciudades;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadesController {

    @Autowired
    private ICiudades iCiudades;

    @GetMapping
    public List<Ciudades> list() {
        return iCiudades.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudades> show(@PathVariable Long id) {
        Optional<Ciudades> ciudad = iCiudades.findById(id);
        return ciudad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ciudades> createCiudad(@RequestBody Ciudades ciudad) {
        Ciudades savedCiudad = iCiudades.save(ciudad);
        return new ResponseEntity<>(savedCiudad, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ciudades> updateCiudad(@PathVariable Long id, @RequestBody Ciudades ciudad) {
        Ciudades updatedCiudad = iCiudades.update(id, ciudad);
        return updatedCiudad != null ? new ResponseEntity<>(updatedCiudad, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCiudad(@PathVariable Long id) {
        if (iCiudades.findById(id).isPresent()) {
            iCiudades.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
