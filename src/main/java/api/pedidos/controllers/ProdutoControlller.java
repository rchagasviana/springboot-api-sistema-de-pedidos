package api.pedidos.controllers;


import api.pedidos.entities.Produto;
import api.pedidos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

    //@GetMapping -> já define o tipo de método
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listarTodos() {
        List<Produto> listaDeProdutos = new ArrayList<>();
        listaDeProdutos = servico.buscarTodos();
        return ResponseEntity.ok().body(listaDeProdutos);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> listarPorId(@PathVariable Long id) {
        Produto produto = new Produto();
        produto = servico.buscarPorId(id);
        return ResponseEntity.ok().body(produto);
    }





}
