package br.com.zupacademy.carolina.casadocodigo.Autor;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

public class AutorDto {


    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    @Length(max = 400)
    private String descricao;

    public AutorDto(Long id, Instant instante, String email, String nome, String descricao) {

        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    public AutorDto(AutorModel autorModel) {
    }


    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public AutorModel converter(AutorRepository autor) {
        return new AutorModel(this.email, this.nome, this.descricao);
    }
}


