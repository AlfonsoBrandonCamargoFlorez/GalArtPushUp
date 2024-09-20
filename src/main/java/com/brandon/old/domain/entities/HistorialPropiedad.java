package com.brandon.old.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class HistorialPropiedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Antiguedades antiguedades;

    

    @ManyToOne
    @JoinColumn(name = "ActualPropietarioId")
    private Persona nuevoPropietario;

    @ManyToOne
    @JoinColumn(name = "AnteriorPropietarioId")
    private Persona anteriorPropietario;
}
