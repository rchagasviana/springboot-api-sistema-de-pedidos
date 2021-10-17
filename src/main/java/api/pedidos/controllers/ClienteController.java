package api.pedidos.controllers;

import api.pedidos.entities.Cidade;
import api.pedidos.entities.Cliente;
import api.pedidos.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService servico;

    //@GetMapping ou
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> buscarTodos() {
        List<Cliente> lista = servico.buscarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> listarPorId(@PathVariable Long id) {
        Cliente cliente = new Cliente();
        cliente = servico.buscarPorId(id);
        return ResponseEntity.ok().body(cliente);
    }


}
