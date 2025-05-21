package com.hospital.hospital.service;

import com.hospital.hospital.model.FichaPaciente;
import com.hospital.hospital.repository.FichaPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichaPacienteService {

    @Autowired
    private FichaPacienteRepository fichaPacienteRepository;

    public List<FichaPaciente> findAll() {
        return fichaPacienteRepository.findAll();
    }

    public Optional<FichaPaciente> findById(Integer id) {
        return fichaPacienteRepository.findById(id);
    }

    public Optional<FichaPaciente> findByPacienteId(Integer pacienteId) {
        return fichaPacienteRepository.findByPacienteId(pacienteId);
    }

    public FichaPaciente save(FichaPaciente fichaPaciente) {
        return fichaPacienteRepository.save(fichaPaciente);
    }

    public void deleteById(Integer id) {
        fichaPacienteRepository.deleteById(id);
    }

    public boolean existsByPacienteId(Integer pacienteId) {
        return fichaPacienteRepository.existsByPacienteId(pacienteId);
    }
}
