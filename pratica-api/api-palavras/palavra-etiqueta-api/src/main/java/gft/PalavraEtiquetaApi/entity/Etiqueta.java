package gft.PalavraEtiquetaApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "etiquetas")
    @JsonIgnore
    private Set<Palavra> palavras = new HashSet<>();


    //Getter e Setters
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
