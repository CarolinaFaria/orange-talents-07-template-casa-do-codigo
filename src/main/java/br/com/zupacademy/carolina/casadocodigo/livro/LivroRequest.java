package br.com.zupacademy.carolina.casadocodigo.livro;


import br.com.zupacademy.carolina.casadocodigo.autor.AutorModel;
import br.com.zupacademy.carolina.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.carolina.casadocodigo.categoria.CategoriaModel;
import br.com.zupacademy.carolina.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.carolina.casadocodigo.validator.ExistsId;
import br.com.zupacademy.carolina.casadocodigo.validator.ValorUnico;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class LivroRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @Lob
    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    @ValorUnico(domainClass = LivroModel.class, fieldName="isbn")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy",shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(domainClass = CategoriaModel.class, fieldName="id")
    private Long idCategoria;

    @NotNull
    @ExistsId(domainClass = AutorModel.class, fieldName="id")
    private Long idAutor;

    public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco,
                        Integer numeroPaginas, String isbn, LocalDate dataPublicacao,
                        Long idCategoria, Long idAutor) {
        this.titulo = titulo;
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
        @NotNull AutorModel autor = autorRepository.findById(idAutor).get();
        @NotNull CategoriaModel categoria = categoriaRepository.findById(idCategoria).get();

        return new LivroModel(this.titulo,this.resumo, this.sumario,
                this.preco, this.numeroPaginas, this.isbn, this.dataPublicacao,
                autor, categoria);
    }
}
