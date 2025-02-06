package com.gft.PalavraEtiquetaApi.entities;

import jakarta.persistence.*;       //Anotacoes de persistencia (java persistence api), permite mapear a classe para um banco de dados
import java.util.Set;               //para armazenar multiplas etiquetas associadas a uma palavra

@Entity     //Indica que a classe e uma entidade JPA/Sera mapeada para uma tabela no banco de dados. E a classe Palavra representa a tabela palavra.
public class Palavra {

    @Id     //marca o campo id como a chave primaria da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //Garante que o valor do id seja gerado automaticamente pelo banco de dados, usando contador incremental (autoincremento).
    private Long id;

    private String termo;   //atributo que representa a palavra ou o termo em si. Sera armazenado em uma coluna na tabela palavra.

    @ManyToMany             //define o relacionamento dentre Palavra e Etiqueta. (muitos para muitos)
    @JoinTable(             // Define a tabela intermediaria etiqueta_palavra que realiza o mapeamento entre as duas entidades.
            name = "palavra_etiqueta",
            joinColumns = @JoinColumn(name = "palavra_id"),        // Define a coluna que refere a chave primaria da etiqueta na tabela intermediaria.
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id") // Define a coluna que refere a chave primaria da palavra na tabela intermediaria.
    )
    private Set<Etiqueta> etiquetas;

    //Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }

    public Set<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(Set<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }
}
