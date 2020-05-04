package mx.com.teclo.sas.ccenter.ws.negocio.service.infraccion;

import mx.com.teclo.sas.ccenter.ws.persistencia.vo.respuesta.RespuestaVO;

public interface IvrInfraccionService {
	
	public RespuestaVO obtenerNumeroInfraccionesPorPlaca(String placa);

}
