package br.com.zupacademy.carolina.casadocodigo.autor;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {


    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutorRequest> cadastrarAutor(@RequestBody @Valid AutorRequest dto){
        AutorModel autorModel = dto.converter(autorRepository);
        autorRepository.save(autorModel);
        return ResponseEntity.ok().build();

    }

}
