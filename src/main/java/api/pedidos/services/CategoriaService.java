package api.pedidos.services;

import api.pedidos.entities.Categoria;
import api.pedidos.repositories.CategoriaRepository;
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
        return categoria.orElse(null);
    }

    public List<Categoria> buscarTodas() {
        return repositorio.findAll();
    }


}
