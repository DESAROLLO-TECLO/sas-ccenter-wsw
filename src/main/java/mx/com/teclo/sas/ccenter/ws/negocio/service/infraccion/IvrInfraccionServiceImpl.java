package mx.com.teclo.sas.ccenter.ws.negocio.service.infraccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.teclo.sas.ccenter.ws.util.enums.Codigos;
import mx.com.teclo.sas.ccenter.ws.util.enums.Mensajes;
import mx.com.teclo.sas.ccenter.ws.persistencia.hibernate.dao.infraccion.InfraccionDAO;
import mx.com.teclo.sas.ccenter.ws.persistencia.vo.respuesta.RespuestaVO;
import mx.com.teclo.sas.ccenter.ws.persistencia.vo.respuesta.SancionesVO;


@Service
public class IvrInfraccionServiceImpl implements IvrInfraccionService{

	@Autowired
	private InfraccionDAO infraccionDAO;
	
	@Transactional
	public RespuestaVO obtenerNumeroInfraccionesPorPlaca(String placa){
		
		RespuestaVO respuestaVO = new RespuestaVO();
		SancionesVO sancionesVO= null;
		Integer valorConsulta=null;
		
		if(placa.equals("null") || placa==null){
			
			respuestaVO.setCodigoHttp(Codigos.BAD_REQUEST.getProcesoId());
			respuestaVO.setDescripcion("El parametro placa es nulo");
			
		}else{
			
			valorConsulta=infraccionDAO.obtenerNumeroInfraccionesPorPlaca(placa);
			
			if(valorConsulta != 0){
				sancionesVO=new SancionesVO();
				sancionesVO.setNumeroSanciones(valorConsulta);
				respuestaVO.setCodigoHttp(Codigos.SUCCESS.getProcesoId());
				respuestaVO.setDescripcion(Mensajes.MSJ_SUCCESS.getProcesoId());
				
			}else{
				
				respuestaVO.setCodigoHttp(Codigos.NOT_DATA_FOUND.getProcesoId());
				respuestaVO.setDescripcion(Mensajes.MSJ_NOT_DATA_FOUND.getProcesoId());
				
			}
			
		}
		respuestaVO.setSancionesVO(sancionesVO);
		
		return respuestaVO;
	}
	
}
