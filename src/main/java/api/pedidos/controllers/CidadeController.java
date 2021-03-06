package api.pedidos.controllers;

import api.pedidos.entities.Cidade;
import api.pedidos.entities.Produto;
import api.pedidos.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeService servico;

    //@GetMapping -> já define o tipo de método
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Cidade>> listarTodas() {
        List<Cidade> listaDeCidades = servico.buscarTodas();
        return ResponseEntity.ok().body(listaDeCidades);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cidade> listarPorId(@PathVariable Long id) {
        Cidade cidade = new Cidade();
        cidade = servico.buscarPorId(id);
        return ResponseEntity.ok().body(cidade);
    }




}
