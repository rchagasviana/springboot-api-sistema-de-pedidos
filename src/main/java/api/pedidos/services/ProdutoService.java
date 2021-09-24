package api.pedidos.services;


import api.pedidos.entities.Produto;
import api.pedidos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repositorio;

    public List<Produto> listarTodos() {
        return repositorio.findAll();
    }


}
