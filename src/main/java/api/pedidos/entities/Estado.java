package api.pedidos.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@NoArgsConstructor
@Entity
@Table(name = "tb_estado")
public class Estado implements Serializable {
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

    //RELACIONAMENTO BIDIRECIONAL
    @Getter
    @OneToMany(mappedBy = "estado") //nome do atributo da outra entidade que mapeou cidades
    private List<Cidade> cidades = new ArrayList<>();


    public Estado(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return id.equals(estado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
