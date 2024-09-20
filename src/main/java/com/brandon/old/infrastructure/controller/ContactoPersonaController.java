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

import com.brandon.old.application.service.IContactoPersona;
import com.brandon.old.domain.entities.ContactoPersona;

@RestController
@RequestMapping("/api/contacto-personas")
public class ContactoPersonaController {

    @Autowired
    private IContactoPersona iContactoPersona;

    @GetMapping
    public List<ContactoPersona> list() {
        return iContactoPersona.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactoPersona> show(@PathVariable Long id) {
        Optional<ContactoPersona> contactoPersona = iContactoPersona.findById(id);
        return contactoPersona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ContactoPersona> createContactoPersona(@RequestBody ContactoPersona contactoPersona) {
        ContactoPersona savedContactoPersona = iContactoPersona.save(contactoPersona);
        return new ResponseEntity<>(savedContactoPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactoPersona> updateContactoPersona(@PathVariable Long id, @RequestBody ContactoPersona contactoPersona) {
        ContactoPersona updatedContactoPersona = iContactoPersona.update(id, contactoPersona);
        return updatedContactoPersona != null ? new ResponseEntity<>(updatedContactoPersona, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactoPersona(@PathVariable Long id) {
        if (iContactoPersona.findById(id).isPresent()) {
            iContactoPersona.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
