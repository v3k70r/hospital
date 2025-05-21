package com.hospital.hospital.controller;

import com.hospital.hospital.model.FichaPaciente;
import com.hospital.hospital.service.FichaPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/fichas")
@CrossOrigin(origins = "*")
public class FichaPacienteController {

    @Autowired
    private FichaPacienteService fichaPacienteService;

    // Listar todas las fichas
    @GetMapping
    public ResponseEntity<List<FichaPaciente>> listar() {
        List<FichaPaciente> fichas = fichaPacienteService.findAll();
        if (fichas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(fichas);
    }

    // Buscar por ID de ficha
    @GetMapping("/{id}")
    public ResponseEntity<FichaPaciente> obtenerPorId(@PathVariable Integer id) {
        return fichaPacienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar por ID de paciente
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<FichaPaciente> obtenerPorPacienteId(@PathVariable Integer pacienteId) {
        return fichaPacienteService.findByPacienteId(pacienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear ficha
    @PostMapping
    public ResponseEntity<FichaPaciente> crear(@RequestBody FichaPaciente fichaPaciente) {
        if (fichaPacienteService.existsByPacienteId(fichaPaciente.getPaciente().getId())) {
            return ResponseEntity.badRequest().build(); // Ya existe ficha para ese paciente
        }
        FichaPaciente nueva = fichaPacienteService.save(fichaPaciente);
        return ResponseEntity.status(201).body(nueva);
    }

    // Actualizar ficha
    @PutMapping("/{id}")
    public ResponseEntity<FichaPaciente> actualizar(@PathVariable Integer id, @RequestBody FichaPaciente fichaPaciente) {
        Optional<FichaPaciente> existente = fichaPacienteService.findById(id);
        if (existente.isPresent()) {
            fichaPaciente.setId(id);
            return ResponseEntity.ok(fichaPacienteService.save(fichaPaciente));
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar ficha
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        Optional<FichaPaciente> existente = fichaPacienteService.findById(id);
        if (existente.isPresent()) {
            fichaPacienteService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
