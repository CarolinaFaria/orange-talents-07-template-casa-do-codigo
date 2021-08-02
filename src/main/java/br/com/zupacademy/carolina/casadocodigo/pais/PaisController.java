package br.com.zupacademy.carolina.casadocodigo.pais;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<PaisRequest> cadastraPais(@RequestBody @Valid PaisRequest dto){
        Pais pais = dto.converter(paisRepository);
        paisRepository.save(pais);
        return ResponseEntity.ok().build();

    }

}
