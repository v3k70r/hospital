package com.hospital.hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ficha_paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichaPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_paciente", nullable = false, unique = true)
    private Paciente paciente;

    @Column(name = "datos_personales", nullable = false)
    private String datosPersonales;

    @Column(name = "datos_personales_2")
    private String datosPersonales2;

    @Column(name = "datos_personales_3")
    private String datosPersonales3;

    @Column(name = "datos_personales_4")
    private String datosPersonales4;

    @Column(name = "datos_personales_5")
    private String datosPersonales5;
}
