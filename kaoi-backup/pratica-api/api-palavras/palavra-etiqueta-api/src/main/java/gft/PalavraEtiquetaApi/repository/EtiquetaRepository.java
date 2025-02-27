package gft.PalavraEtiquetaApi.repository;

import gft.PalavraEtiquetaApi.entity.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long>  {
}
