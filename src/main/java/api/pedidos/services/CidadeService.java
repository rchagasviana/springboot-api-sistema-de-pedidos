package api.pedidos.services;

import api.pedidos.entities.Cidade;
import api.pedidos.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repositorioCidade;

    public List<Cidade>  buscarTodas(){
        return repositorioCidade.findAll();
    }
}
