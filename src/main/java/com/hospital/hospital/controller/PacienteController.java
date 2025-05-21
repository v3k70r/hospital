package com.hospital.hospital.controller;

import com.hospital.hospital.model.Paciente;
import com.hospital.hospital.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/pacientes")
@CrossOrigin(origins = "*") // Opcional: permite llamadas desde frontend
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // ✅ Listar todos
    @GetMapping
    public ResponseEntity<List<Paciente>> listar() {
        List<Paciente> pacientes = pacienteService.findAll();
        if (pacientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacientes);
    }

    // ✅ Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPorId(@PathVariable Integer id) {
        Optional<Paciente> paciente = Optional.ofNullable(pacienteService.findById(id));
        return paciente.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Crear nuevo paciente
    @PostMapping
    public ResponseEntity<Paciente> crear(@RequestBody Paciente paciente) {
        if (pacienteService.existePorRun(paciente.getRun())) {
            return ResponseEntity.badRequest().build();
        }
        Paciente nuevo = pacienteService.save(paciente);
        return ResponseEntity.status(201).body(nuevo);
    }

    // ✅ Actualizar paciente existente
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Integer id, @RequestBody Paciente paciente) {
        Optional<Paciente> existente = Optional.ofNullable(pacienteService.findById(id));
        if (existente.isPresent()) {
            paciente.setId(id);
            return ResponseEntity.ok(pacienteService.save(paciente));
        }
        return ResponseEntity.notFound().build();
    }

    // ✅ Eliminar paciente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id) {
        Optional<Paciente> existente = Optional.ofNullable(pacienteService.findById(id));
        if (existente.isPresent()) {
            pacienteService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

