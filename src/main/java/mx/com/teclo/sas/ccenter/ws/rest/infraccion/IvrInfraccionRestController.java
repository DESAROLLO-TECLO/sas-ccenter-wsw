package mx.com.teclo.sas.ccenter.ws.rest.infraccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.teclo.sas.ccenter.ws.negocio.service.infraccion.IvrInfraccionService;
import mx.com.teclo.sas.ccenter.ws.persistencia.vo.respuesta.RespuestaVO;
import mx.com.teclo.sas.ccenter.ws.persistencia.vo.respuesta.SancionesVO;
import mx.com.teclo.arquitectura.ortogonales.responsehttp.NotFoundHttpResponse;
import mx.com.teclo.arquitectura.ortogonales.responsehttp.OKHttpResponse;


@RestController
public class IvrInfraccionRestController {
	
	private static final String AUTOR_APP="TCL";
	private static final String NUMERO_SERVICIO_01="01";
	
	@Autowired
	private IvrInfraccionService ivrInfraccionService;
	
	/**
	 * @name   servicio 01
	 * @author DanielUnitis
	 * @param placa
	 * @return
	 * @throws NotFoundHttpResponse
	 * @throws OKHttpResponse
	 */
	@RequestMapping(value="/ivrSancionesPorPlaca", method = RequestMethod.GET)
	public ResponseEntity<SancionesVO> obtenerNumInfraccionesPorPlaca(@RequestParam(name = "placa",defaultValue="null") 
													String placa)throws NotFoundHttpResponse,OKHttpResponse{
		
		RespuestaVO respuestaVO=ivrInfraccionService.obtenerNumeroInfraccionesPorPlaca(placa);
		
		SancionesVO sancionesVO=respuestaVO.getSancionesVO();
		String codigo=AUTOR_APP+respuestaVO.getCodigoHttp()+NUMERO_SERVICIO_01;
		
		if(sancionesVO==null)
			throw new NotFoundHttpResponse(respuestaVO.getDescripcion(),codigo,sancionesVO);
		else
			throw new OKHttpResponse(respuestaVO.getDescripcion(),codigo,sancionesVO);

				
	}

}
