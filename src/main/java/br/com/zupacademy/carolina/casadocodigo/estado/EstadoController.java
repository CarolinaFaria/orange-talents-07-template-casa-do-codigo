package br.com.zupacademy.carolina.casadocodigo.estado;

import br.com.zupacademy.carolina.casadocodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    public EstadoController(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastraEstado(@RequestBody @Valid EstadoRequest dto){
        Estado estado = dto.converter(paisRepository);
        estadoRepository.save(estado);
        return ResponseEntity.ok().build();

    }
}
