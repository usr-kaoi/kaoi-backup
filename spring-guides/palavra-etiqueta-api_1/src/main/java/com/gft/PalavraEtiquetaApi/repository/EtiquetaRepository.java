package com.gft.PalavraEtiquetaApi.repository;

import com.gft.PalavraEtiquetaApi.entity.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;  // Fornece implementacoes automaticas para as operacoes CRUD basicas.

public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> { // A extensao da JPA fornece operacoes CRUD para a entidade Etiqueta.
}
