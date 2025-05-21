package com.hospital.hospital.repository;

import com.hospital.hospital.model.Atencion;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtencionRepository extends JpaRepository<Atencion, Integer> {
    List<Atencion> findByPacienteId(Integer pacienteId);

    List<Atencion> findByMedicoIdMedico(Integer medicoIdMedico);
}
