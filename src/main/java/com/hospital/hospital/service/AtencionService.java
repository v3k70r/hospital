package com.hospital.hospital.service;

import com.hospital.hospital.model.Atencion;
import com.hospital.hospital.repository.AtencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtencionService {

    @Autowired
    private AtencionRepository atencionRepository;

    public List<Atencion> findAll() {
        return atencionRepository.findAll();
    }

    public Optional<Atencion> findById(Integer id) {
        return atencionRepository.findById(id);
    }

    public List<Atencion> findByPacienteId(Integer pacienteId) {
        return atencionRepository.findByPacienteId(pacienteId);
    }

    public List<Atencion> findByMedicoId(Integer medicoIdMedico) {
        return atencionRepository.findByMedicoIdMedico(medicoIdMedico);
    }

    public Atencion save(Atencion atencion) {
        return atencionRepository.save(atencion);
    }

    public void deleteById(Integer id) {
        atencionRepository.deleteById(id);
    }
}
