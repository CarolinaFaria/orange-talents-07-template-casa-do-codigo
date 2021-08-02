package br.com.zupacademy.carolina.casadocodigo.livro;


import br.com.zupacademy.carolina.casadocodigo.autor.AutorModel;
import br.com.zupacademy.carolina.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.carolina.casadocodigo.categoria.CategoriaModel;
import br.com.zupacademy.carolina.casadocodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroRequest> cadastraLivro(@RequestBody @Valid LivroRequest livro){
        LivroModel livroModel = livro.converter(autorRepository,categoriaRepository);
        livroRepository.save(livroModel);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<ListaLivroResponse> listaLivros(){

        List<LivroModel> livros = livroRepository.findAll();

        return ListaLivroResponse.converter(livros);
    }


}
