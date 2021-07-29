package br.com.zupacademy.carolina.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaRequest> cadastrarCategoria(@RequestBody @Valid CategoriaRequest dto){
        CategoriaModel categoriaModel = dto.converter(categoriaRepository);
        categoriaRepository.save(categoriaModel);

        return ResponseEntity.ok().build();

    }


}
