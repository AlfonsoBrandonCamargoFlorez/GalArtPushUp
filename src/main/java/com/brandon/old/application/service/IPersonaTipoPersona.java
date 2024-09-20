package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.PersonaTipoPersona;

public interface IPersonaTipoPersona {
    Optional<PersonaTipoPersona> findById(Long id);
    List<PersonaTipoPersona> getAll();
    PersonaTipoPersona save(PersonaTipoPersona categoria);
    PersonaTipoPersona update(Long id, PersonaTipoPersona categoria);
    void deleteById(Long id);

}
