package com.gft.api.service;

import com.gft.api.entity.Gato;
import com.gft.api.repository.GatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class GatoService {

    @Autowired
    private GatoRepository gatoRepository;

    public List<Gato> findAll() {
        return gatoRepository.findAll();
    }

    public Optional<Gato> findById(Long id) {
        return gatoRepository.findById(id);
    }

    public Gato save(Gato gato) {
        return gatoRepository.save(gato);
    }

    public void deleteById(Long id) {
        gatoRepository.deleteAllById(Collections.singleton(id));
    }
}
