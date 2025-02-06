package com.gft.PalavraEtiquetaApi.controllers;


import com.gft.PalavraEtiquetaApi.entity.Etiqueta;
import com.gft.PalavraEtiquetaApi.repository.EtiquetaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Marca a classe como um controlador RESTful, que lida com as requisicoes HTTP e retorna respostas JSON.
@RequestMapping("/api/etiquetas") // Define a URL base para os endpoints da classe. Todos os endpoints terao o prefixo /api/etiquetas
public class EtiquetaController {

    private final EtiquetaRepository etiquetaRepository;

    public EtiquetaController(EtiquetaRepository etiquetaRepository) {
        this.etiquetaRepository = etiquetaRepository;
    }

    @GetMapping
    public List<Etiqueta> getAllEtiquetas() {
        return etiquetaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Etiqueta> getEtiquetaById(@PathVariable Long id) {
        return etiquetaRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Etiqueta createEtiqueta(@RequestBody Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    @PutMapping({"/{id}"})
    public Etiqueta updateEtiqueta(@PathVariable Long id, @RequestBody Etiqueta etiqueta) {
        etiqueta.setId(id);
        return etiquetaRepository.save(etiqueta);
    }

    @DeleteMapping("/{id}")
    public void deleteEtiqueta(@PathVariable Long id) {
        etiquetaRepository.deleteById(id);
    }

}
