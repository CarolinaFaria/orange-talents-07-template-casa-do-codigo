package br.com.zupacademy.carolina.casadocodigo.autor;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Table(name="Autor")
@Entity
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Instant instanteCadastro = Instant.now();

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    @Length(max = 400)
    private String descricao;

    public AutorModel(String email, String nome, String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    public AutorModel() {
    }


}
