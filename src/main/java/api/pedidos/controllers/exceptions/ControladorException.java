package api.pedidos.controllers.exceptions;


/*
 *Classe utilizada pra interceptar as exceções geradas pela classe de serviço
 *  */

import api.pedidos.services.exceptions.ObjetoNaoEncontradoException;
import api.pedidos.services.exceptions.ObjetoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

@ControllerAdvice
public class ControladorException {

    @ExceptionHandler(ObjetoNaoEncontradoException.class) //Trata exceções com objetos desse tipo
    public ResponseEntity<ModeloErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontradoException objetoLancadoPeloService, HttpServletRequest requisicao) {

       /* String dadosDaRequisicao = "PROTOCOLO:"
                + requisicao.getProtocol() + "--" +
                "MÉTODO:" + requisicao.getMethod() + "--" +
                "URI:" + requisicao.getRequestURI();*/

        String dadosDaRequisicao = "URI:" + requisicao.getRequestURI();

        ModeloErroPadrao erro = new ModeloErroPadrao(
                HttpStatus.NOT_FOUND.value(), //o código de erro http. Neste caso, retornará o 404
                objetoLancadoPeloService.getMessage(), // a mensagem personalizada criada
                System.currentTimeMillis(), //momento que a exceção ocorreu,
                dadosDaRequisicao
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }


}
