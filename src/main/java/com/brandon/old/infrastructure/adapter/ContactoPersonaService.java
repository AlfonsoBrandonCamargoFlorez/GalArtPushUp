package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IContactoPersona;
import com.brandon.old.domain.entities.ContactoPersona;
import com.brandon.old.infrastructure.repository.ContactoPersonaRepository;

@Service
public class ContactoPersonaService implements IContactoPersona {

    @Autowired
    private ContactoPersonaRepository contactoPersonaRepository;

    @Override
    public Optional<ContactoPersona> findById(Long id) {
        return contactoPersonaRepository.findById(id);
    }

    @Override
    public List<ContactoPersona> getAll() {
        return contactoPersonaRepository.findAll();
    }

    @Override
    public ContactoPersona save(ContactoPersona contactoPersona) {
        return contactoPersonaRepository.save(contactoPersona);
    }

    @Override
    public ContactoPersona update(Long id, ContactoPersona contactoPersona) {
        return contactoPersonaRepository.findById(id)
            .map(existingContacto -> {
                existingContacto.setNumero(contactoPersona.getNumero());
                existingContacto.setClasecontacto(contactoPersona.getClasecontacto());
                existingContacto.setPersona(contactoPersona.getPersona());
                return contactoPersonaRepository.save(existingContacto);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        contactoPersonaRepository.deleteById(id);
    }
}
