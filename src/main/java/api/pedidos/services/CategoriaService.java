package api.pedidos.services;

import api.pedidos.entities.Categoria;
import api.pedidos.repositories.CategoriaRepository;
import api.pedidos.services.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repositorio;

    public Categoria buscarPorId(Long id) {
        Optional<Categoria> categoria = repositorio.findById(id);
        return categoria.orElseThrow(
                //() -> new ObjetoNaoEncontradoException("Categoria de Id=" + id + " não encontrada! " + ", Tipo objeto: " + Categoria.class.getName()));
                () -> new ObjetoNaoEncontradoException("Id " + id + " não encontrado!")
        );
    }

    public List<Categoria> buscarTodas() {
        return repositorio.findAll();
    }


}
