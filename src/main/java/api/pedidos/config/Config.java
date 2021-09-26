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
        Categoria categoria1 = new Categoria(
                null,
                "Informática"
        );
        Categoria categoria2 = new Categoria(
                null,
                "Eletrônico"
        );
        Categoria categoria3 = new Categoria(
                null,
                "Material de Escritório"
        );
        Categoria categoria4 = new Categoria(
                null,
                "Alimentação"
        );
        Categoria categoria5 = new Categoria(
                null,
                "Lazer"
        );

        repositorioCategoria.saveAll(Arrays.asList(categoria1, categoria2, categoria3, categoria4, categoria5));

        //POPULANDO PRODUTO
        Produto produto1 = new Produto(
                null,
                "Notebook",
                3458.00);
        Produto produto2 = new Produto(
                null,
                "Placa de Vídeo",
                876.00);
        Produto produto3 = new Produto(
                null,
                "Cadeira de Escritório",
                540.00);
        Produto produto4 = new Produto(
                null,
                "Mesa de Escritório",
                650.00);
        Produto produto5 = new Produto(
                null,
                "Água Mineral",
                3.00);
        Produto produto6 = new Produto(
                null,
                "Livro de Estudo",
                0.75);


        //ASSOACIADO AS TABELAS CATEGORIA AOS PRODUTOS

        /*
        * A tabela Produto possui a referência (JoinTable) para a terceira tabela "produto_tegoria", logo
        * a operação abaixo é obrigatória para que a tabela "produto_tegoria" seja populada com as relações de
        * produto com categoria."
        * */

        /*
        * A operação abaixo é obrigatória quando se deseja popular a terceira tabela
        *
        * */
        produto1.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
        produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
        produto3.getCategorias().addAll(Arrays.asList(categoria3));
        produto4.getCategorias().addAll(Arrays.asList(categoria3));
        produto5.getCategorias().addAll(Arrays.asList(categoria4));
        

        repositorioProduto.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5, produto6));


    }

}
