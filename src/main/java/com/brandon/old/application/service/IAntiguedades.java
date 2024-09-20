package com.brandon.old.application.service;

import java.util.List;
import java.util.Optional;

import com.brandon.old.domain.entities.Antiguedades;

public interface IAntiguedades {
    Optional<Antiguedades> findById(Long id);
    List<Antiguedades> getAll();
    Antiguedades save(Antiguedades antiguedad);
    Antiguedades update(Long id,Antiguedades antiguedad);
    void deleteById(Long id); 



}
