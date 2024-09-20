package com.brandon.old.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.old.application.service.IPersonaTipoPersona;
import com.brandon.old.domain.entities.PersonaTipoPersona;
import com.brandon.old.infrastructure.repository.PersonaTipoPersonaRepository;

@Service
public class PersonaTipoPersonaService implements IPersonaTipoPersona {

    @Autowired
    private PersonaTipoPersonaRepository personaTipoPersonaRepository;

    @Override
    public Optional<PersonaTipoPersona> findById(Long id) {
        return personaTipoPersonaRepository.findById(id);
    }

    @Override
    public List<PersonaTipoPersona> getAll() {
        return personaTipoPersonaRepository.findAll();
    }

    @Override
    public PersonaTipoPersona save(PersonaTipoPersona personaTipoPersona) {
        return personaTipoPersonaRepository.save(personaTipoPersona);
    }

    @Override
    public PersonaTipoPersona update(Long id, PersonaTipoPersona personaTipoPersona) {
        return personaTipoPersonaRepository.findById(id)
            .map(existingPersonaTipoPersona -> {
                existingPersonaTipoPersona.setPersona(personaTipoPersona.getPersona());
                existingPersonaTipoPersona.setTipoPersona(personaTipoPersona.getTipoPersona());
                return personaTipoPersonaRepository.save(existingPersonaTipoPersona);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        personaTipoPersonaRepository.deleteById(id);
    }
}
