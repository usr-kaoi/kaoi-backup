package com.gft.PalavraEtiquetaApi.entity;

import jakarta.persistence.*;       //Anotacoes de persistencia (java persistence api), permite mapear a classe para um banco de dados.
import java.util.Set;               //para armazenar multiplas palavras associadas a uma etiqueta.

@Entity     //Indica que a classe e uma entidade JPA, ou seja, sera mapeada para uma tabela no banco de dados.
public class Etiqueta {

    @Id //  Define o campo id como chave primaria.
    @GeneratedValue(strategy =  GenerationType.IDENTITY) // A chave primaria sera gerada automaticamente pelo banco (autoincremento)
    private Long id;

    private String nome; // Atributo nome representa o nome da etiqueta. Sera armazenado em uma coluna na tabela etiqueta.

    @ManyToMany(mappedBy = "etiquetas")
    private Set<Palavra> palavras;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Palavra> getPalavras() {
        return palavras;
    }

    public void setPalavras(Set<Palavra> palavras) {
        this.palavras = palavras;
    }
}
