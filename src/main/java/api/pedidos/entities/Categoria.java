package api.pedidos.entities;


import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@NoArgsConstructor
@Entity
@Table(name = "tb_categoria")
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "nome")
    private String nome;

    //RELACIONAMENTOS
    //Este mapeamento é necessário apenas para relacionamentos bidirecionais
    @Getter
    @ManyToMany(mappedBy = "categorias") //nome do atributo ddo outro lado onde o mapeamento foi feito
    private List<Produto> produtos = new ArrayList<>();


    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id.equals(categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
