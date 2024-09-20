package com.brandon.old.domain.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String apellido;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String puesto;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String salario;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String comision;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String fechaContratacion;




    
    @OneToOne
    private Persona persona;
    
}
