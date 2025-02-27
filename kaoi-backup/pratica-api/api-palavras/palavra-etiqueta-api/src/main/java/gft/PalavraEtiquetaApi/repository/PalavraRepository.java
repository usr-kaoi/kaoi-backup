package gft.PalavraEtiquetaApi.repository;

import gft.PalavraEtiquetaApi.entity.Palavra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PalavraRepository extends JpaRepository<Palavra, Long> {
}
