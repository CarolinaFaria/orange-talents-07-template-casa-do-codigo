package br.com.zupacademy.carolina.casadocodigo.livro;


import br.com.zupacademy.carolina.casadocodigo.autor.AutorModel;
import br.com.zupacademy.carolina.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.carolina.casadocodigo.categoria.CategoriaModel;
import br.com.zupacademy.carolina.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.carolina.casadocodigo.validator.ExistsId;
import br.com.zupacademy.carolina.casadocodigo.validator.ValorUnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @JsonProperty(value="titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    @JsonProperty(value="resumo")
    private String resumo;

    @Lob
    @NotBlank
    @JsonProperty(value="sumario")
    private String sumario;

    @NotNull
    @Min(20)
    @JsonProperty(value="preco")
    private BigDecimal preco;

    @Min(100)
    @JsonProperty(value="numeroPaginas")
    private Integer numeroPaginas;

    @NotBlank
    @ValorUnico(domainClass = LivroModel.class, fieldName="isbn")
    @JsonProperty(value="isbn")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy",shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(domainClass = CategoriaModel.class, fieldName="id")
    @JsonProperty(value="idCategoria")
    private Long idCategoria;

    @NotNull
    @ExistsId(domainClass = AutorModel.class, fieldName="id")
    @JsonProperty(value="idAutor")
    private Long idAutor;


    public LivroRequest() {
    }

    public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco,
                        Integer numeroPaginas, String isbn, LocalDate dataPublicacao,
                        Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public LivroModel converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        AutorModel autor = autorRepository.findById(idAutor).get();
        CategoriaModel categoria = categoriaRepository.findById(idCategoria).get();

        return new LivroModel(this.titulo,this.resumo, this.sumario,
                this.preco, this.numeroPaginas, this.isbn, this.dataPublicacao,
                autor, categoria);
    }

}
