package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.ContactoPersona;

public interface IContactoPersona {
    Optional<ContactoPersona> findById(Long id);
    List<ContactoPersona> getAll();
    ContactoPersona save(ContactoPersona categoria);
    ContactoPersona update(Long id, ContactoPersona categoria);
    void deleteById(Long id);

}
