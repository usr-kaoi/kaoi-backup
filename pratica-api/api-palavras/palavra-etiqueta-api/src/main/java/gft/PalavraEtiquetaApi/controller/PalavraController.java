package gft.PalavraEtiquetaApi.controller;

import gft.PalavraEtiquetaApi.entity.Etiqueta;
import gft.PalavraEtiquetaApi.entity.Palavra;
import gft.PalavraEtiquetaApi.repository.EtiquetaRepository;
import gft.PalavraEtiquetaApi.repository.PalavraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/palavras")
public class PalavraController {

    @Autowired
    private PalavraRepository palavraRepository;

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @GetMapping
    public List<Palavra> getAll() {
        return palavraRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Palavra> getById(@PathVariable Long id) {
        return palavraRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Palavra create(@RequestBody Palavra palavra) {
        return palavraRepository.save(palavra);
    }

    @PutMapping("/{id}")
    public Palavra update(@PathVariable Long id, @RequestBody Palavra palavra) {
        palavra.setId(id);
        return palavraRepository.save(palavra);
    }

    @PatchMapping("/{id}")
    public Palavra partialUpdate(@PathVariable Long id, @RequestBody Palavra palavra) {
        palavra.setId(id);
        return palavraRepository.save(palavra);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        palavraRepository.deleteById(id);
    }

    @PostMapping("/{palavraId}/etiquetas/{etiquetaId}")
    @ResponseStatus(HttpStatus.OK)
    public Palavra associarEtiqueta(@PathVariable Long palavraId, @PathVariable Long etiquetaId) {
        Optional<Palavra> palavraOpt = palavraRepository.findById(palavraId);
        Optional<Etiqueta> etiquetaOpt = etiquetaRepository.findById(etiquetaId);

        if (palavraOpt.isPresent() && etiquetaOpt.isPresent()) {
            Palavra palavra = palavraOpt.get();
            Etiqueta etiqueta = etiquetaOpt.get();

            palavra.getEtiquetas().add(etiqueta);
            etiqueta.getPalavras().add(palavra);

            palavraRepository.save(palavra);
            etiquetaRepository.save(etiqueta);

            return palavra;
        } else {
            throw new RuntimeException("Palavra ou Etiqueta não encontrada.");
        }
    }

    @DeleteMapping("/{palavraId}/etiquetas/{etiquetaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociarEtiqueta(@PathVariable Long palavraId, @PathVariable Long etiquetaId) {
        Optional<Palavra> palavraOpt = palavraRepository.findById(palavraId);
        Optional<Etiqueta> etiquetaOpt = etiquetaRepository.findById(etiquetaId);

        if (palavraOpt.isPresent() && etiquetaOpt.isPresent()) {
            Palavra palavra = palavraOpt.get();
            Etiqueta etiqueta = etiquetaOpt.get();

            palavra.getEtiquetas().remove(etiqueta);
            palavraRepository.save(palavra);

        } else {
            throw new RuntimeException("Palavra ou Etiqueta não encontrada.");
        }
    }

    @GetMapping("/{palavraId}/etiquetas")
    public List<Etiqueta> getEtiquetasByPalavra(@PathVariable Long palavraId) {
        Optional<Palavra> palavraOpt = palavraRepository.findById(palavraId);
        if (palavraOpt.isPresent()) {
            return new ArrayList<>(palavraOpt.get().getEtiquetas());
        } else {
            throw new RuntimeException("Palavra não encontrada.");
        }
    }

}

