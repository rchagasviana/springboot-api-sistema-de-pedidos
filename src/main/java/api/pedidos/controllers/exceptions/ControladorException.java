package api.pedidos.controllers.exceptions;


/*
 *Classe utilizada pra interceptar as exceções geradas pela classe de serviço
 *  */

import api.pedidos.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

@ControllerAdvice
public class ControladorException {


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ModeloErroPadrao> objectNotFound(ObjectNotFoundException e, HttpServletRequest requisicao) {
        ModeloErroPadrao erro = new ModeloErroPadrao(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                System.currentTimeMillis()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }


}
