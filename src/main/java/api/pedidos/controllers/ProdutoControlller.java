package api.pedidos.controllers;


import api.pedidos.entities.Produto;
import api.pedidos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoControlller {

    @Autowired
    private ProdutoService servico;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listarTodos() {
        List<Produto> listaProdutos = new ArrayList<>();
        listaProdutos = servico.listarTodos();
        return ResponseEntity.ok().body(listaProdutos);
    }


}
