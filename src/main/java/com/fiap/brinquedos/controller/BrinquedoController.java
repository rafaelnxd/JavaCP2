package com.fiap.brinquedos.controller;

import com.fiap.brinquedos.model.Brinquedo;
import com.fiap.brinquedos.service.BrinquedoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoService brinquedoService;

    // Endpoint para listar todos os brinquedos
    @GetMapping
    public List<Brinquedo> getAllBrinquedos() {
        return brinquedoService.getAllBrinquedos();
    }

    // Endpoint para obter um brinquedo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Brinquedo> getBrinquedoById(@PathVariable Long id) {
        Optional<Brinquedo> brinquedo = brinquedoService.getBrinquedoById(id);
        return brinquedo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para criar um novo brinquedo
    @PostMapping
    public ResponseEntity<Brinquedo> createBrinquedo(@RequestBody Brinquedo brinquedo) {
        Brinquedo novoBrinquedo = brinquedoService.saveBrinquedo(brinquedo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoBrinquedo);
    }

    // Endpoint para atualizar um brinquedo existente
    @PutMapping("/{id}")
    public ResponseEntity<Brinquedo> updateBrinquedo(@PathVariable Long id, @RequestBody Brinquedo brinquedo) {
        Brinquedo brinquedoAtualizado = brinquedoService.updateBrinquedo(id, brinquedo);
        if (brinquedoAtualizado != null) {
            return ResponseEntity.ok(brinquedoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para deletar um brinquedo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrinquedo(@PathVariable Long id) {
        brinquedoService.deleteBrinquedo(id);
        return ResponseEntity.noContent().build();
    }
}
