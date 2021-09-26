package api.pedidos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
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
}
