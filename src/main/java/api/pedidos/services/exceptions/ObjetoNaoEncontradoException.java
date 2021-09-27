package api.pedidos.services.exceptions;


public class ObjetoNaoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjetoNaoEncontradoException(String message) {
        super(message);
    }

    public ObjetoNaoEncontradoException(String message, Throwable causaExcecao) {
        super(message, causaExcecao);
    }

}
