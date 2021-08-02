package br.com.zupacademy.carolina.casadocodigo.detalhelivro;


import br.com.zupacademy.carolina.casadocodigo.livro.LivroModel;

import java.math.BigDecimal;

public class DetalheLivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private String nomeAutor;
    private String descricaoAutor;

    public DetalheLivroResponse(LivroModel livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.nomeAutor = livro.getAutorModel().getNome();
        this.descricaoAutor = livro.getAutorModel().getDescricao();
    }



    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescricaoAutor() {
        return descricaoAutor;
    }
}
