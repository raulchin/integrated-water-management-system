package com.sigap.partner.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table( name = "socios" )
@Data
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_socio")
    private Long idPartner;

    @Column(name = "cedula_ruc", nullable = false, unique = true, length = 20)
    private String taxIdentification;

    @Column( name = "nombres", nullable = false, length = 100)
    private String names;

    @Column (name = "apellidos", nullable = false, length = 100 )
    private String lastName;

    @Column( name = "direccion", columnDefinition = "TEXT" )
    private String address;

    @Column( name = "telefono", nullable = false, length = 20 )
    private String phone;

    private String email;

    @Column( name = "estado" )
    private Boolean status = true;

    @Column(name = "fecha_registro", insertable = false, updatable = false)
    private LocalDate registrationDate;

}
