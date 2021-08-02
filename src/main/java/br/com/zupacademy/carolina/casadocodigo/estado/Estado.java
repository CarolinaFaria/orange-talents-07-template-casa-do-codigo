package br.com.zupacademy.carolina.casadocodigo.estado;

import br.com.zupacademy.carolina.casadocodigo.pais.Pais;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @ManyToOne
    private Pais pais;

    public Estado() {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Estado(String nome, Long idPais) {
    }
}
