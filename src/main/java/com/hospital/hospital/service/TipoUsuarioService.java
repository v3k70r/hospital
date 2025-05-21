package com.hospital.hospital.service;

import com.hospital.hospital.model.TipoUsuario;
import com.hospital.hospital.repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public List<TipoUsuario> findAll() {
        return tipoUsuarioRepository.findAll();
    }

    public Optional<TipoUsuario> findById(Integer id) {
        return tipoUsuarioRepository.findById(id);
    }

    public TipoUsuario save(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public void deleteById(Integer id) {
        tipoUsuarioRepository.deleteById(id);
    }
}
