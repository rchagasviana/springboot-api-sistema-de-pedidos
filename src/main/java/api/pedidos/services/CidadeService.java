package api.pedidos.services;

import api.pedidos.entities.Cidade;
import api.pedidos.repositories.CidadeRepository;
import api.pedidos.services.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repositorio;

    public Cidade buscarPorId(Long id) {
        Optional<Cidade> cidade = repositorio.findById(id);
        return cidade.orElseThrow(
                () -> new ObjetoNaoEncontradoException("Id " + id + " não encontrado!")
        );
    }

    public List<Cidade> buscarTodas() {
        return repositorio.findAll();
    }
}
