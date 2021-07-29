package br.com.zupacademy.carolina.casadocodigo.categoria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Categoria")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;


    public CategoriaModel() { }

    public CategoriaModel(String nome) {
        this.nome = nome;
    }

}
