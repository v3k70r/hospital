package com.hospital.hospital.controller;

import com.hospital.hospital.model.TipoUsuario;
import com.hospital.hospital.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/tipos-usuario")
@CrossOrigin(origins = "*")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping
    public ResponseEntity<List<TipoUsuario>> listar() {
        List<TipoUsuario> lista = tipoUsuarioService.findAll();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> obtenerPorId(@PathVariable Integer id) {
        Optional<TipoUsuario> encontrado = tipoUsuarioService.findById(id);
        return encontrado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoUsuario> crear(@RequestBody TipoUsuario tipoUsuario) {
        return ResponseEntity.status(201).body(tipoUsuarioService.save(tipoUsuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuario> actualizar(@PathVariable Integer id, @RequestBody TipoUsuario tipoUsuario) {
        Optional<TipoUsuario> existente = tipoUsuarioService.findById(id);
        if (existente.isPresent()) {
            tipoUsuario.setId(id);
            return ResponseEntity.ok(tipoUsuarioService.save(tipoUsuario));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (tipoUsuarioService.findById(id).isPresent()) {
            tipoUsuarioService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
