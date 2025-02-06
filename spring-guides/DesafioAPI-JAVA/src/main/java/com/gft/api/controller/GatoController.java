package com.gft.api.controller;

import com.gft.api.entity.Gato;
import com.gft.api.service.GatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gatos")
public class GatoController {

    @Autowired
    private GatoService gatoService;

    @GetMapping
    public List<Gato> getAllGatos() {
        return gatoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gato> getGatoById(@PathVariable Long id) {
        return gatoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Gato createGato(@RequestBody Gato gato) {
        return gatoService.save(gato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gato> updateGato(@PathVariable Long id, @RequestBody Gato gatoDetails) {
        return gatoService.findById(id)
                .map(gato -> {
                    gato.setNome(gatoDetails.getNome());
                    gato.setRaca(gatoDetails.getRaca());
                    gato.setImagemUrl(gatoDetails.getImagemUrl());
                    return ResponseEntity.ok(gatoService.save(gato));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGato(@PathVariable Long id) {
        gatoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
