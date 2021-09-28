package api.pedidos.entities;


import api.pedidos.entities.enums.TipoCliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@NoArgsConstructor
@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
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
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Getter
    @Setter
    @Column(name = "cpfOuCnpj", nullable = false, unique = true, length = 15)
    private String cpfOuCnpj;

    @Column(name = "tipo", nullable = false)
    private Integer tipo;

    //RELACIONAMENTOS
    /*
     * 1) Cliente (1:n) Endereço
     *
     * Este é necessário apenas para quando se deseja fazer relacionamento bidirecional
     * */
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    /**
     * 2) Cliente (1:n) Telefone
     * Cliente possui vários telefones, mas cada registro de telefone precisa se único. A chave primária
     * de Telefone é a própria chave estrangeira, sendo assim a tabela Telefone (entidade fraca) é totalmente dependente de
     * Cliente. Por esse motivo escolheu-se usar Telefone como uma Coleção do tipo Set uma vez que este
     * tipo não permite elementos repetidos e uma classe para representar a tabela..
     */
    @ElementCollection
    @CollectionTable(name = "tb_telefone")
    private Set<String> telefone = new HashSet<>();


    public Cliente(Long id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo.getCodigo(); // ou setTipo(tipo)
    }

    public TipoCliente getTipo() {
        return TipoCliente.converteParaEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCodigo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
