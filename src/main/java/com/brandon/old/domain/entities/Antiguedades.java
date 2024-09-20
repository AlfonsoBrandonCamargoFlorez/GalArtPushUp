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
public class Antiguedades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String descripcion;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private long precio;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String estadoConservacion;

    // @Column(nullable = false)
    // private LocalDate fechaCambio;

    @Temporal(TemporalType.DATE)
    private Date fechaMovimiento;

    @ManyToOne
    private EpocaAntiguedad epocaAntiguedad;

    @ManyToOne
    private Categorias categorias;

    @ManyToOne
    private Sucursal sucursal;

}
