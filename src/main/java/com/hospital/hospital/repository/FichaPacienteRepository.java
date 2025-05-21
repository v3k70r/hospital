package com.hospital.hospital.repository;

import com.hospital.hospital.model.FichaPaciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FichaPacienteRepository extends JpaRepository<FichaPaciente, Integer> {
    Optional<FichaPaciente> findByPacienteId(Integer pacienteId);
    boolean existsByPacienteId(Integer pacienteId);
}
