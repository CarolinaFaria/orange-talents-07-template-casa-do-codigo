package br.com.zupacademy.carolina.casadocodigo.cliente;

import br.com.zupacademy.carolina.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.carolina.casadocodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    @Autowired
    PaisRepository paisRepository;

    @Autowired
    EstadoRepository estadoRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public ResponseEntity<ClienteRequest> cadastraCliente(@RequestBody @Valid ClienteRequest cliente){
        ClienteModel clienteModel = cliente.converter(paisRepository, estadoRepository);
        clienteRepository.save(clienteModel);
        return ResponseEntity.ok().build();
    }


}
