package br.com.zupacademy.carolina.casadocodigo.livro;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class ListaLivroResponse {

    private Long id;
    private String titulo;

    public ListaLivroResponse() {
    }

    public ListaLivroResponse(LivroModel livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<ListaLivroResponse> converter(List<LivroModel> livros) {
        List<ListaLivroResponse> listaDto = new ArrayList<>();
        for(LivroModel livro : livros){
            ListaLivroResponse dto = new ListaLivroResponse(livro);
            listaDto.add(dto);
        }
        return listaDto;
    }
}
