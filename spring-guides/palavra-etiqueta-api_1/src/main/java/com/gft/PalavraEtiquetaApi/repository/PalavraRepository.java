package com.gft.PalavraEtiquetaApi.repository;

import com.gft.PalavraEtiquetaApi.entity.Palavra;
import org.springframework.data.jpa.repository.JpaRepository;   // Fornece implementacoes automaticas para as operacoes CRUD basicas.

public interface PalavraRepository extends JpaRepository<Palavra, Long>{ // A extensao da JPA fornece operacoes CRUD para a entidade Palavras
}
