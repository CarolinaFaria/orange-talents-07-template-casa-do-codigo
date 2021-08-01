package br.com.zupacademy.carolina.casadocodigo.autor;

import br.com.zupacademy.carolina.casadocodigo.validator.ValorUnico;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorRequest {

    @NotBlank
    @Email
    @ValorUnico(domainClass = AutorModel.class, fieldName="email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    @Length(max = 400)
    private String descricao;

    public AutorRequest(String email, String nome, String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    public AutorRequest(AutorModel autorModel) { }

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


