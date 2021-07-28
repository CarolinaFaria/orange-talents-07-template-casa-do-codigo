package br.com.zupacademy.carolina.casadocodigo.autor;

import br.com.zupacademy.carolina.casadocodigo.autor.validator.ValidacaoEmailDuplicadoAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutorRequest> cadastrarAutor(@RequestBody @Valid AutorRequest dto){
        AutorModel autorModel = dto.converter(autorRepository);

        autorRepository.save(autorModel);

        return ResponseEntity.ok().build();

    }

}
