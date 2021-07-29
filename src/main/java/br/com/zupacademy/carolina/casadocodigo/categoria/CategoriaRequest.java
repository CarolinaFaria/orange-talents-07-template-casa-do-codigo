package br.com.zupacademy.carolina.casadocodigo.categoria;


import br.com.zupacademy.carolina.casadocodigo.validator.ValorUnico;
import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @ValorUnico(domainClass = CategoriaModel.class, fieldName="nome")
    @NotBlank
    private String nome;

    public CategoriaRequest() { }

    public CategoriaRequest(CategoriaModel categoriaModel) { }

    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaModel converter(CategoriaRepository categoriaRepository) {
        return new CategoriaModel(this.nome);
    }


}
