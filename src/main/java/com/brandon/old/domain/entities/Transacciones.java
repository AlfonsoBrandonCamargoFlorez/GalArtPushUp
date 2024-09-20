package com.brandon.old.domain.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Transacciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double monto;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
    private TipoTransaccion tipoTransaccion;

    @ManyToOne
    @JoinColumn(name = "compradorId")
    private Persona comprador;

    @ManyToOne
    @JoinColumn(name = "vendedorId")
    private Persona vendedor;

    @ManyToOne
    private EstacionPago estacionPago;

}
