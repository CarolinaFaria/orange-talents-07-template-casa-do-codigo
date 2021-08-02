package br.com.zupacademy.carolina.casadocodigo.cliente;

import br.com.zupacademy.carolina.casadocodigo.estado.Estado;
import br.com.zupacademy.carolina.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.carolina.casadocodigo.pais.Pais;
import br.com.zupacademy.carolina.casadocodigo.pais.PaisRepository;
import br.com.zupacademy.carolina.casadocodigo.validator.CPForCNPJ;
import br.com.zupacademy.carolina.casadocodigo.validator.ExistsId;
import br.com.zupacademy.carolina.casadocodigo.validator.ValorUnico;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ClienteRequest {

    @Email
    @NotBlank
    @ValorUnico(domainClass = ClienteModel.class, fieldName = "email")
    @JsonProperty(value="email")
    private String email;

    @NotBlank
    @JsonProperty(value="nome")
    private String nome;

    @NotBlank
    @JsonProperty(value="sobrenome")
    private String sobrenome;

    @NotBlank
    @CPForCNPJ
    @JsonProperty(value="documento")
    @ValorUnico(domainClass = ClienteModel.class, fieldName = "documento")
    private String documento;

    @NotBlank
    @JsonProperty(value="endereco")
    private String endereco;
    @NotBlank
    @JsonProperty(value="complemento")
    private String complemento;
    @NotBlank
    @JsonProperty(value="cidade")
    private String cidade;
    @NotBlank
    @JsonProperty(value="telefone")
    private String telefone;
    @NotBlank
    @JsonProperty(value="cep")
    private String cep;

    @NotNull
    @ExistsId(domainClass = Pais.class, message = "Não existe País com o id informado na base de dados", fieldName = "id")
    private Long idPais;

    private Long idEstado;

    @Deprecated
    public ClienteRequest() {
    }

    public ClienteRequest(String email, String nome, String sobrenome,
                          String documento, String endereco, String complemento,
                          String cidade, String telefone,
                          String cep, Long idPais, Long idEstado) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.idPais = idPais;
        this.idEstado = idEstado;
    }

    public ClienteModel converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Pais pais = paisRepository.getById(idPais);
        if(idEstado == null) {
            return new ClienteModel(email,nome,sobrenome,documento,endereco,complemento,cidade,telefone,cep,pais);

        }
        else {
            Estado estado = estadoRepository.getById(idEstado);
            return new ClienteModel(email,nome,sobrenome,documento,endereco,complemento,cidade,telefone,cep,pais, estado);
        }
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }
}
