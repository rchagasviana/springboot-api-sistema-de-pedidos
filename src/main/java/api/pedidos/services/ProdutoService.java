package api.pedidos.services;


import api.pedidos.entities.Categoria;
import api.pedidos.entities.Produto;
import api.pedidos.repositories.ProdutoRepository;
import api.pedidos.services.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repositorio;


    public Produto buscarPorId(Long id) {
        Optional<Produto> produto = repositorio.findById(id);
        //return produto.orElse(null);
        return produto.orElseThrow(
                //  () -> new ObjetoNaoEncontradoException("Produto de Id=" + id + " não encontrado! " + ", Tipo objeto: " + Produto.class.getName())
                () -> new ObjetoNaoEncontradoException("Id " + id + " não encontrado!")
        );
    }


    public List<Produto> listarTodos() {
        return repositorio.findAll();
    }


}
