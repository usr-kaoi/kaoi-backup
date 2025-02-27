package br.com.erudio.cambio_service.repository;

import br.com.erudio.cambio_service.model.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

    Cambio findByFromAndTo(String from, String to);
}
