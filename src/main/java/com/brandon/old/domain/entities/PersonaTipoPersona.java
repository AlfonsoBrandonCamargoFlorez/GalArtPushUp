package com.brandon.old.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class PersonaTipoPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    

    @ManyToOne
    private Persona persona;

    @ManyToOne
    private TipoPersona tipoPersona;
}
