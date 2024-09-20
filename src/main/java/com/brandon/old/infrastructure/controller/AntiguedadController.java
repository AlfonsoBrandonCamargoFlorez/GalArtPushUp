package com.brandon.old.infrastructure.controller;

import java.util.List;

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

import com.brandon.old.application.service.IAntiguedades;
import com.brandon.old.domain.entities.Antiguedades;

@RestController
@RequestMapping("/api/antiguedades")
public class AntiguedadController {

    @Autowired
    private IAntiguedades antiguedadesService;

    @GetMapping
    public ResponseEntity<List<Antiguedades>> getAllAntiguedades() {
        List<Antiguedades> antiguedades = antiguedadesService.getAll();
        return ResponseEntity.ok(antiguedades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Antiguedades> getAntiguedadById(@PathVariable Long id) {
        return antiguedadesService.findById(id)
            .map(antiguedad -> ResponseEntity.ok(antiguedad))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Antiguedades> createAntiguedad(@RequestBody Antiguedades antiguedades) {
        Antiguedades createdAntiguedad = antiguedadesService.save(antiguedades);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAntiguedad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Antiguedades> updateAntiguedad(@PathVariable Long id, @RequestBody Antiguedades antiguedades) {
        Antiguedades updatedAntiguedad = antiguedadesService.update(id, antiguedades);
        return updatedAntiguedad != null ? ResponseEntity.ok(updatedAntiguedad) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAntiguedad(@PathVariable Long id) {
        if (antiguedadesService.findById(id).isPresent()) {
            antiguedadesService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
