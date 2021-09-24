package api.pedidos.config;

import api.pedidos.entities.Categoria;
import api.pedidos.entities.Produto;
import api.pedidos.repositories.CategoriaRepository;
import api.pedidos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class Config implements CommandLineRunner {

    @Autowired
    private CategoriaRepository repositorioCategoria;

    @Autowired
    private ProdutoRepository repositorioProduto;

    @Override
    public void run(String... args) throws Exception {

        //POPULANDO CATEGORIA
        Categoria categoria01 = new Categoria(
                null,
                "Informática"
        );

        Categoria categoria02 = new Categoria(
                null,
                "Escritório"
        );

        Categoria categoria03 = new Categoria(
                null,
                "Alimentação"
        );

        Categoria categoria04 = new Categoria(
                null,
                "Eletrônico"
        );
        repositorioCategoria.saveAll(Arrays.asList(categoria01, categoria02, categoria03, categoria04));


        //POPULANDO PRODUTO


        //repositorioProduto.saveAll(Arrays.asList(produto01, produto02, produto03));


    }

}
