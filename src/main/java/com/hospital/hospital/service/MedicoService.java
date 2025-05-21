package com.hospital.hospital.service;

import com.hospital.hospital.model.Medico;
import com.hospital.hospital.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> findById(Integer id) {
        return medicoRepository.findById(id);
    }

    public Optional<Medico> findByRunMedico(String runMedico) {
        return medicoRepository.findByRunMedico(runMedico);
    }

    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void deleteById(Integer id) {
        medicoRepository.deleteById(id);
    }
}
