package api.pedidos.controllers;

import api.pedidos.entities.Categoria;
import api.pedidos.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    //@GetMapping -> já define o tipo de método
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Categoria categoria = new Categoria();
        categoria = service.buscarPorId(id);
        return ResponseEntity.ok().body(categoria);
    }

    //@GetMapping -> já define o tipo de método
    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listarTodas() {
        return service.buscarTodas();
    }


}
