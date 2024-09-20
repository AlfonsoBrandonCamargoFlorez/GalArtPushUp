package com.brandon.old.domain.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String apellido;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;


    @ManyToOne
    private Genero genero;    

    @ManyToOne
    private Sucursal sucursal;

    @ManyToOne
    private EstadoPersona estadoPersona;
}
