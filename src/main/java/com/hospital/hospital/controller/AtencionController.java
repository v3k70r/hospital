package com.hospital.hospital.controller;

import com.hospital.hospital.model.Atencion;
import com.hospital.hospital.service.AtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/atenciones")
@CrossOrigin(origins = "*")
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @GetMapping
    public ResponseEntity<List<Atencion>> listar() {
        List<Atencion> atenciones = atencionService.findAll();
        if (atenciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(atenciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atencion> obtenerPorId(@PathVariable Integer id) {
        return atencionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Atencion>> obtenerPorPaciente(@PathVariable Integer pacienteId) {
        List<Atencion> atenciones = atencionService.findByPacienteId(pacienteId);
        return atenciones.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(atenciones);
    }

    @GetMapping("/medico/{medicoId}")
    public ResponseEntity<List<Atencion>> obtenerPorMedico(@PathVariable Integer medicoId) {
        List<Atencion> atenciones = atencionService.findByMedicoId(medicoId);
        return atenciones.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(atenciones);
    }

    @PostMapping
    public ResponseEntity<Atencion> crear(@RequestBody Atencion atencion) {
        Atencion nueva = atencionService.save(atencion);
        return ResponseEntity.status(201).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atencion> actualizar(@PathVariable Integer id, @RequestBody Atencion atencion) {
        Optional<Atencion> existente = atencionService.findById(id);
        if (existente.isPresent()) {
            atencion.setId(id);
            return ResponseEntity.ok(atencionService.save(atencion));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        Optional<Atencion> existente = atencionService.findById(id);
        if (existente.isPresent()) {
            atencionService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
