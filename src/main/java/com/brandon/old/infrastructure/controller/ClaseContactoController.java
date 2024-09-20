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

import com.brandon.old.application.service.IClaseContacto;
import com.brandon.old.domain.entities.ClaseContacto;

@RestController
@RequestMapping("/api/clase-contacto")
public class ClaseContactoController {

    @Autowired
    private IClaseContacto iClaseContacto;

    @GetMapping
    public List<ClaseContacto> list() {
        return iClaseContacto.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaseContacto> show(@PathVariable Long id) {
        Optional<ClaseContacto> claseContacto = iClaseContacto.findById(id);
        return claseContacto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClaseContacto> createClaseContacto(@RequestBody ClaseContacto claseContacto) {
        ClaseContacto savedClaseContacto = iClaseContacto.save(claseContacto);
        return new ResponseEntity<>(savedClaseContacto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaseContacto> updateClaseContacto(@PathVariable Long id, @RequestBody ClaseContacto claseContacto) {
        ClaseContacto updatedClaseContacto = iClaseContacto.update(id, claseContacto);
        return updatedClaseContacto != null ? new ResponseEntity<>(updatedClaseContacto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaseContacto(@PathVariable Long id) {
        if (iClaseContacto.findById(id).isPresent()) {
            iClaseContacto.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
