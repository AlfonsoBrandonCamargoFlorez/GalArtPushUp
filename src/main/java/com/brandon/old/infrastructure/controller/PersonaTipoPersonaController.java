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

import com.brandon.old.application.service.IPersonaTipoPersona;
import com.brandon.old.domain.entities.PersonaTipoPersona;

@RestController
@RequestMapping("/api/personas-tipo")
public class PersonaTipoPersonaController {

    @Autowired
    private IPersonaTipoPersona iPersonaTipoPersona;

    @GetMapping
    public List<PersonaTipoPersona> list() {
        return iPersonaTipoPersona.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaTipoPersona> show(@PathVariable Long id) {
        Optional<PersonaTipoPersona> personaTipoPersona = iPersonaTipoPersona.findById(id);
        return personaTipoPersona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PersonaTipoPersona> createPersonaTipo(@RequestBody PersonaTipoPersona personaTipoPersona) {
        PersonaTipoPersona savedPersonaTipo = iPersonaTipoPersona.save(personaTipoPersona);
        return new ResponseEntity<>(savedPersonaTipo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaTipoPersona> updatePersonaTipo(@PathVariable Long id, @RequestBody PersonaTipoPersona personaTipoPersona) {
        PersonaTipoPersona updatedPersonaTipo = iPersonaTipoPersona.update(id, personaTipoPersona);
        return updatedPersonaTipo != null ? new ResponseEntity<>(updatedPersonaTipo, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonaTipo(@PathVariable Long id) {
        if (iPersonaTipoPersona.findById(id).isPresent()) {
            iPersonaTipoPersona.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
