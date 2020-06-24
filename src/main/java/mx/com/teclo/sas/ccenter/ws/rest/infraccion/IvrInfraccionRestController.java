package mx.com.teclo.sas.ccenter.ws.rest.infraccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.teclo.arquitectura.ortogonales.responsehttp.BadRequestHttpResponse;
import mx.com.teclo.sas.ccenter.ws.negocio.service.infraccion.IvrInfraccionService;


@RestController
public class IvrInfraccionRestController {

	@Autowired
	private IvrInfraccionService ivrInfraccionService;
	
	/**
	 * @name Servicio 01
	 * @author unitis0521
	 * @param placa String
	 * @return Integer
	 * @throws BadRequestHttpResponse
	 */
	@RequestMapping(value="/ivrTienenSancionesPorPlaca", method = RequestMethod.GET)
	public ResponseEntity<Integer> obtenerSancionesPorPlaca(
			@RequestParam(name = "placa", defaultValue = "null") String placa) 
					throws BadRequestHttpResponse{
		
		Integer respuestaVO=ivrInfraccionService.obtenerNumeroInfraccionesPorPlaca(placa);
		
		if(respuestaVO == 0)
			return new ResponseEntity<Integer>(0, HttpStatus.NOT_FOUND);
			//throw new OKHttpResponse("TCL20001", 0);
		else
			return new ResponseEntity<Integer>(1, HttpStatus.OK);
			//throw new OKHttpResponse("TCL40401", respuestaVO);
	}
	
	/**
	 * @name Servicio 02
	 * @author unitis0521
	 * @param placa String
	 * @return Integer
	 * @throws BadRequestHttpResponse
	 */
	@RequestMapping(value="/ivrSancionesNpPorPlaca", method = RequestMethod.GET)
	public ResponseEntity<Integer> obtenerNumSancionesNoPagadasPorPlaca(
			@RequestParam(name = "placa", defaultValue = "null") String placa) 
					throws BadRequestHttpResponse{
		
		Integer respuestaVO=ivrInfraccionService.obtenerNumeroInfraccionesPorPlaca(placa);
		
		if(respuestaVO == 0)
			return new ResponseEntity<Integer>(0, HttpStatus.NOT_FOUND);
			//throw new OKHttpResponse("TCL20001", 0);
		else
			return new ResponseEntity<Integer>(respuestaVO, HttpStatus.OK);
			//throw new OKHttpResponse("TCL40401", respuestaVO);
	}

}
