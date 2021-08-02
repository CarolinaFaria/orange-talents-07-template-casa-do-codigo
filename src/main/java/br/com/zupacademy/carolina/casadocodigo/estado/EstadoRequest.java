package br.com.zupacademy.carolina.casadocodigo.estado;

import br.com.zupacademy.carolina.casadocodigo.pais.Pais;
import br.com.zupacademy.carolina.casadocodigo.pais.PaisRepository;
import br.com.zupacademy.carolina.casadocodigo.validator.ExistsId;
import br.com.zupacademy.carolina.casadocodigo.validator.PaisUnico;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank
    @JsonProperty(value="nome")
    private String nome;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName="id")
    @PaisUnico
    @JsonProperty(value="idPais")
    private Long idPais;

    public EstadoRequest(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado converter(PaisRepository paisRepository) {
        Pais pais = paisRepository.getById(idPais);
        return new Estado(nome, pais);
    }
}
