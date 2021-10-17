package api.pedidos.services;

import api.pedidos.entities.Categoria;
import api.pedidos.entities.Cliente;
import api.pedidos.repositories.ClienteRepository;
import api.pedidos.services.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repositorio;

    public List<Cliente> buscarTodos() {
        return repositorio.findAll();
    }

    public Cliente buscarPorId(Long id) {
        Optional<Cliente> categoria = repositorio.findById(id);
        return categoria.orElseThrow(
                () -> new ObjetoNaoEncontradoException("Id " + id + " não encontrado!")
        );
    }

}
