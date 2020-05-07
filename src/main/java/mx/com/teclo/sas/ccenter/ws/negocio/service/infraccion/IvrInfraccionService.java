package mx.com.teclo.sas.ccenter.ws.negocio.service.infraccion;

import mx.com.teclo.arquitectura.ortogonales.responsehttp.BadRequestHttpResponse;

public interface IvrInfraccionService {
	
	Integer obtenerNumeroInfraccionesPorPlaca(String placa) throws BadRequestHttpResponse;

}
