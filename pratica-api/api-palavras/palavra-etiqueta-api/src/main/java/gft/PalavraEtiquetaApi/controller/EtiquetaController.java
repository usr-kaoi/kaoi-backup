package gft.PalavraEtiquetaApi.controller;

import gft.PalavraEtiquetaApi.entity.Etiqueta;
import gft.PalavraEtiquetaApi.entity.Palavra;
import gft.PalavraEtiquetaApi.repository.EtiquetaRepository;
import gft.PalavraEtiquetaApi.repository.PalavraRepository;
import org.hibernate.engine.spi.EntityUniqueKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etiquetas")
public class EtiquetaController {

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Autowired
    private PalavraRepository palavraRepository;

    @GetMapping
    public List<Etiqueta> getAll() {
        return etiquetaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Etiqueta> getById(@PathVariable Long id) {
        return etiquetaRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Etiqueta create(@RequestBody Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    @PutMapping("/{id}")
    public Etiqueta update(@PathVariable Long id, @RequestBody Etiqueta etiqueta) {
        etiqueta.setId(id);
        return etiquetaRepository.save(etiqueta);
    }

    @PatchMapping("/{id}")
    public Etiqueta partialUpdate(@PathVariable Long id, @RequestBody Etiqueta etiqueta) {
        etiqueta.setId(id);
        return etiquetaRepository.save(etiqueta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        etiquetaRepository.deleteById(id);
    }

    @PostMapping("/{etiquetaId}/palavras/{palavraId}")
    @ResponseStatus(HttpStatus.OK)
    public Etiqueta associarPalavra(@PathVariable Long etiquetaId, @PathVariable Long palavraId) {
        Optional<Etiqueta> etiquetaOpt = etiquetaRepository.findById(etiquetaId);
        Optional<Palavra> palavraOpt = palavraRepository.findById(palavraId);

        if (etiquetaOpt.isPresent() && palavraOpt.isPresent()) {
            Etiqueta etiqueta = etiquetaOpt.get();
            Palavra palavra = palavraOpt.get();

            etiqueta.getPalavras().add(palavra);
            palavra.getEtiquetas().add(etiqueta);

            etiquetaRepository.save(etiqueta);  // Salva a etiqueta com a nova associação
            palavraRepository.save(palavra);

            return etiqueta;
        } else {
            throw new RuntimeException("Etiqueta ou Palavra não encontrada.");
        }
    }

    @DeleteMapping("/{etiquetaId}/palavras/{palavraId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociarPalavra(@PathVariable Long etiquetaId, @PathVariable Long palavraId) {
        Optional<Etiqueta> etiquetaOpt = etiquetaRepository.findById(etiquetaId);
        Optional<Palavra> palavraOpt = palavraRepository.findById(palavraId);

        if (etiquetaOpt.isPresent() && palavraOpt.isPresent()) {
            Etiqueta etiqueta = etiquetaOpt.get();
            Palavra palavra = palavraOpt.get();

            etiqueta.getPalavras().remove(palavra);
            etiquetaRepository.save(etiqueta);
        } else {
            throw new RuntimeException("Etiqueta ou Palavra não encontrada.");
        }
    }

    @GetMapping("/{etiquetaId}/palavras")
    public List<Palavra> getPalavrasByEtiqueta(@PathVariable Long etiquetaId) {
        Optional<Etiqueta> etiquetaOpt = etiquetaRepository.findById(etiquetaId);

        if (etiquetaOpt.isPresent()) {
            return new ArrayList<>(etiquetaOpt.get().getPalavras());
        } else {
            throw new RuntimeException("Etiqueta não encontrada.");
        }
    }

}
