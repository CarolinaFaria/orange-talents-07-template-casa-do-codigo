package br.com.zupacademy.carolina.casadocodigo.cliente;

import br.com.zupacademy.carolina.casadocodigo.estado.Estado;
import br.com.zupacademy.carolina.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String documento;

    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;

    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;


    @Deprecated
    public ClienteModel() {
    }

    public ClienteModel(String email, String nome, String sobrenome,
                        String documento, String endereco, String complemento,
                        String cidade, String telefone, String cep,
                        Pais pais, Estado estado) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
    }

    public ClienteModel(String email, String nome, String sobrenome,
                        String documento, String endereco, String complemento,
                        String cidade, String telefone, String cep, Pais pais) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }
}
