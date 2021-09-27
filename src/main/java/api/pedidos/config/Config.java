package api.pedidos.config;

import api.pedidos.entities.Categoria;
import api.pedidos.entities.Cidade;
import api.pedidos.entities.Estado;
import api.pedidos.entities.Produto;
import api.pedidos.repositories.CategoriaRepository;
import api.pedidos.repositories.CidadeRepository;
import api.pedidos.repositories.EstadoRepository;
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

    @Autowired
    private EstadoRepository repositorioEstado;

    @Autowired
    private CidadeRepository repositorioCidade;

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
         * a operação abaixo é obrigatória para que a tabela "produto_tegoria" sej apopulada com as relações de
         * produto com categoria."
         * */
        produto1.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
        produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
        produto3.getCategorias().addAll(Arrays.asList(categoria3));
        produto4.getCategorias().addAll(Arrays.asList(categoria3));
        produto5.getCategorias().addAll(Arrays.asList(categoria4));


        repositorioCategoria.saveAll(Arrays.asList(categoria1, categoria2, categoria3, categoria4, categoria5));
        repositorioProduto.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5, produto6));

        //POPULAR ESTADO

        Estado estado1 = new Estado(
                null,
                "Maranhão"
        );
        Estado estado2 = new Estado(
                null,
                "Pará"
        );

        Estado estado3 = new Estado(
                null,
                "Rio de Janeiro"
        );

        Estado estado4 = new Estado(
                null,
                "Rio Grande do Sul"
        );

        repositorioEstado.saveAll(Arrays.asList(estado1, estado2, estado3, estado4));

        //POPULANDO CIDADE
        Cidade cidade1 = new Cidade(
                null,
                "São Luís",
                estado1
        );
        Cidade cidade2 = new Cidade(
                null,
                "Imperatriz",
                estado1
        );
        Cidade cidade3 = new Cidade(
                null,
                "Caxias",
                estado1
        );

        Cidade cidade4 = new Cidade(
                null,
                "Belém",
                estado2
        );

        Cidade cidade5 = new Cidade(
                null,
                "Marabá",
                estado2
        );

        Cidade cidade6 = new Cidade(
                null,
                "Niterói",
                estado3
        );

        Cidade cidade7 = new Cidade(
                null,
                "Gramado",
                estado4
        );

        Cidade cidade8 = new Cidade(
                null,
                "Canela",
                estado4
        );

        repositorioCidade.saveAll(Arrays.asList(cidade1, cidade2, cidade3, cidade4, cidade5, cidade6, cidade7, cidade8));
    }

}
