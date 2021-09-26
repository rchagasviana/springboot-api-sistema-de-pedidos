package api.pedidos.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class ModeloErroPadrao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Getter
    @Setter
    private Integer codigoStatus;
    @Getter
    @Setter
    private String mensagem;
    @Getter
    @Setter
    private Long tempo;




}
