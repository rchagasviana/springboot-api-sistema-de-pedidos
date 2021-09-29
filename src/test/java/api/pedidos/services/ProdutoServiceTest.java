package api.pedidos.services;

import api.pedidos.entities.Produto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoServiceTest {


    @Autowired
    private ProdutoService servico;

    @Test
    public void buscarPorId() {
        Produto produto = new Produto();
        produto = servico.buscarPorId(1L);
        assertEquals("Notebook", produto.getNome());
        assertEquals(3458.0, produto.getPreco());
    }

    @Test
    public void listarTodos() {
        servico.listarTodos();
    }


}