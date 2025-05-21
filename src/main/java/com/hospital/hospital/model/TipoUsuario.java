package com.hospital.hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tipo_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Integer id;

    @Column(length = 40, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "tipoUsuario", cascade = CascadeType.ALL)
    private List<Paciente> pacientes;
}
