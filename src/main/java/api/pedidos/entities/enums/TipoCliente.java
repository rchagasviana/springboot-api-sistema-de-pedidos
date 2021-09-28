package api.pedidos.entities.enums;

public enum TipoCliente {

    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private int codigo;
    private String descricao;

    private TipoCliente(int codgo, String descricao) {
        this.codigo = codgo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    /*
    * Converte o valor inteiro pra o tipo de enum
    * */
    public static TipoCliente converteParaEnum(Integer codigo) {

        if (codigo == null) {
            return null;
        }

        for (TipoCliente valor : TipoCliente.values()) {
            if (valor.getCodigo() == codigo) {
                return valor; //recebe o código e retorna o objeto do tipo do enum
            }
        }
        throw new IllegalArgumentException("Código Inválido");
    }


}
