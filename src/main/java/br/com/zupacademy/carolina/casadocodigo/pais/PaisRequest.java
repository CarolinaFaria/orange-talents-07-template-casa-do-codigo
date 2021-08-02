package br.com.zupacademy.carolina.casadocodigo.pais;

import br.com.zupacademy.carolina.casadocodigo.validator.ValorUnico;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @ValorUnico(domainClass = Pais.class, fieldName="nome")
    @JsonProperty(value="nome")
    private String nome;

    public PaisRequest() {
    }

    public PaisRequest(String nome) {
        this.nome = nome;
    }

    public Pais converter(PaisRepository paisRepository) {
        return new Pais(this.nome);
    }
}
