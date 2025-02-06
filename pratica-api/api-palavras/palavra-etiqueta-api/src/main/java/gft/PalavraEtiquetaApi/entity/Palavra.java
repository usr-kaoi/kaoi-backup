package gft.PalavraEtiquetaApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Palavra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String termo;

    @ManyToMany
    @JoinTable(
            name = "palavra_etiqueta",
            joinColumns = @JoinColumn(name = "palavra_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    @JsonIgnore
    private Set<Etiqueta> etiquetas = new HashSet<>();


    // Getter e Setter
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
