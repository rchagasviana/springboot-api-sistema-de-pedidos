package api.pedidos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@NoArgsConstructor
@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "nome", nullable = false)
    private String nome;

    @Getter
    @Setter
    @Column(name = "preco", nullable = false)
    private Double preco;

    //RELACIONAMENTOS
    /*
    * COMENTÁIO 01: As coleções não precisam de método set, uma vez que a inserção dos dados será feita pelo método nativo da lista*/
    @JsonIgnore
    @Getter
    @ManyToMany
    @JoinTable(
            name = "tb_produto_categoria",
            joinColumns = @JoinColumn(name = "idProduto"),
            inverseJoinColumns = @JoinColumn(name = "idCategoria")
    )
    private List<Categoria> categorias = new ArrayList<>();


    public Produto(Long id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
