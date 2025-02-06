package com.gft.PalavraEtiquetaApi.controllers;

import com.gft.PalavraEtiquetaApi.entities.Palavra;
import com.gft.PalavraEtiquetaApi.repositories.PalavraRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController     // Marca a classe como um controlador RESTful, que lida com as requisicoes HTTP e retorna respostas JSON.
@RequestMapping("/api/palavras")    // Define a URL base para os endpoints da classe. Todos os endpoints terao o prefixo /api/etiquetas
public class PalavraController {

    private final PalavraRepository palavraRepository;

    public PalavraController(PalavraRepository palavraRepository) {
        this.palavraRepository = palavraRepository;
    }

    @GetMapping
    public List<Palavra> getAllPalavras() {
        return palavraRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Palavra> getPalavraById(@PathVariable Long id) {
        return palavraRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Palavra createPalavra(@RequestBody Palavra palavra) {
        return palavraRepository.save(palavra);
    }

    @PutMapping("/{id}")
    public Palavra updatePalavra(@PathVariable Long id, @RequestBody Palavra palavra) {
        palavra.setId(id);
        return palavraRepository.save(palavra);
    }

    @DeleteMapping("/{id}")
    public void deletePalavra(@PathVariable Long id) {
        palavraRepository.deleteById(id);
    }
}
