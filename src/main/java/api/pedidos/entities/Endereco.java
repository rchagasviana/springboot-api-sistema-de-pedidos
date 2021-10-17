package api.pedidos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "logradouro", nullable = false, length = 500)
    private String logradouro;

    @Getter
    @Setter
    @Column(name = "numero", nullable = false, length = 6)
    private String numero;

    @Getter
    @Setter
    @Column(name = "complemento", nullable = true)
    private String complemento;

    @Getter
    @Setter
    @Column(name = "bairro", nullable = false, length = 100)
    private String bairro;

    @Getter
    @Setter
    @Column(name = "cep", nullable = false, length = 10)
    private String cep;

    //RELACIONAMENTOS
    /*
     * 1) Cliente (1:n) Endereço
     * */
    @JsonIgnore
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    /*
    * 2) Cidade (1:n) Endereço
    * Neste caso, foi optado por não fazer o mpeamento bidirecional entre Cidade e Endereço, logo somente
    * a tabela Endereço que conhece a tabela Cidade.
    * */
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    public Endereco(Long id, String logradouro, String numero, String complemento, String bairro, String cep, Cliente cliente, Cidade cidade) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cliente = cliente;
        this.cidade = cidade;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return id.equals(endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
