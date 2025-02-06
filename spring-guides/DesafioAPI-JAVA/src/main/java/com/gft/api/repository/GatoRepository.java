package com.gft.api.repository;

import com.gft.api.entity.Gato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GatoRepository extends JpaRepository<Gato, Long> {
}
