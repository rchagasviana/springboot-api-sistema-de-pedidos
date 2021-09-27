package api.pedidos.controllers;

import api.pedidos.entities.Cidade;
import api.pedidos.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    //@GetMapping -> já define o tipo de método
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Cidade>> listarTodas() {
        List<Cidade> lista = cidadeService.buscarTodas();
        return ResponseEntity.ok().body(lista);
    }


}
