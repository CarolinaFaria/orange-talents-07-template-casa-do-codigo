package br.com.zupacademy.carolina.casadocodigo.detalhelivro;


import br.com.zupacademy.carolina.casadocodigo.livro.LivroModel;
import br.com.zupacademy.carolina.casadocodigo.livro.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class DetalheLivroController {

    DetalheLivroResponse detalheLivroResponse;

    @Autowired
    LivroRepository livroRepository;

    @GetMapping("/{id}")
    public ResponseEntity<DetalheLivroResponse> detalhesLivro(@PathVariable Long id){
        Optional<LivroModel> livro = livroRepository.findById(id);

        if(livro.isPresent()){
            return ResponseEntity.ok().body(new DetalheLivroResponse(livro.get()));
        }
        return ResponseEntity.notFound().build();
    }
}

