package com.gft.PalavraEtiquetaApi.repositories;

import com.gft.PalavraEtiquetaApi.entities.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;  // Fornece implementacoes automaticas para as operacoes CRUD basicas.

public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> { // A extensao da JPA fornece operacoes CRUD para a entidade Etiqueta.
}
