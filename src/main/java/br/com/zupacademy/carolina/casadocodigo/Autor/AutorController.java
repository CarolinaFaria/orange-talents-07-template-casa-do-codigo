package br.com.zupacademy.carolina.casadocodigo.Autor;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutorDto> cadastrarAutor(@RequestBody @Valid AutorDto dto){
        AutorModel autorModel = dto.converter(autorRepository);

        autorRepository.save(autorModel);

        return ResponseEntity.ok().build();

    }

}
