package mx.com.teclo.sas.ccenter.ws.negocio.service.deposito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.teclo.sas.ccenter.ws.persistencia.vo.respuesta.DepositoVO;
import mx.com.teclo.sas.ccenter.ws.persistencia.vo.respuesta.RespuestaVO;
import mx.com.teclo.sas.ccenter.ws.util.enums.Codigos;
import mx.com.teclo.sas.ccenter.ws.util.enums.Mensajes;
import mx.com.teclo.sas.ccenter.ws.persistencia.hibernate.dao.depostio.DepositoDAO;

@Service
public class IvrDepositoServiceImpl implements IvrDepositoService{

	@Autowired
	private DepositoDAO depositoDAO;
	
	@Override
	@Transactional
	public RespuestaVO ivrObtenerDepositoIdPorPlaca(String placa) {
		
		Long depIdopc1;
		Long depIdopc2;
		RespuestaVO respuestaVO = new RespuestaVO();
		DepositoVO depositoVO = null;
		
		if(placa.equals("null") || placa==null){
			respuestaVO.setCodigoHttp(Codigos.BAD_REQUEST.getProcesoId());
			respuestaVO.setDescripcion("El parametro placa es nulo");
		}else{
			
			depositoVO=new DepositoVO();
			depIdopc1= depositoDAO.obtenerDepositoIdPorPlacaImpresaNull(placa);
			depIdopc2=depositoDAO.obtenerDepositoIdPorPlacaImpresaNotNull(placa);
			
			if(depIdopc1 != null && depIdopc2 == null)
				depositoVO.setNumeroDeposito(depIdopc1);
				
			if(depIdopc1 == null && depIdopc2 != null)
				depositoVO.setNumeroDeposito(depIdopc2);
				
			if(depositoVO.getNumeroDeposito()==null){
				depositoVO=null;
				respuestaVO.setCodigoHttp(Codigos.NOT_DATA_FOUND.getProcesoId());
				respuestaVO.setDescripcion(Mensajes.MSJ_NOT_DATA_FOUND.getProcesoId());
			}else{
				respuestaVO.setCodigoHttp(Codigos.SUCCESS.getProcesoId());
				respuestaVO.setDescripcion(Mensajes.MSJ_SUCCESS.getProcesoId());
			}
				
		}
		respuestaVO.setDepositoVO(depositoVO);
		
		return respuestaVO;
	}

	@Override
	@Transactional
	public RespuestaVO ivrObtenerDepositoIdPorInfraccion(String infraccion) {
	
		Long depIdopc1;
		Long depIdopc2;
		DepositoVO depositoVO = null;
		RespuestaVO respuestaVO = new RespuestaVO();
		
		if(infraccion.equals("null") || infraccion==null){
			respuestaVO.setCodigoHttp(Codigos.BAD_REQUEST.getProcesoId());
			respuestaVO.setDescripcion("El parametro infracción es nulo");
		}else{
			depositoVO= new DepositoVO();
			depIdopc1=depositoDAO.obtenerDepositoIdPorInfraccionImpresaNull(infraccion);
			depIdopc2=depositoDAO.obtenerDepositoIdPorInfraccionImpresaNotNull(infraccion);
			
			if(depIdopc1 != null && depIdopc2 == null)
				depositoVO.setNumeroDeposito(depIdopc1);
					
			if(depIdopc1 == null && depIdopc2 != null)
				depositoVO.setNumeroDeposito(depIdopc2);
			
			if(depositoVO.getNumeroDeposito()==null){
				depositoVO=null;
				respuestaVO.setCodigoHttp(Codigos.NOT_DATA_FOUND.getProcesoId());
				respuestaVO.setDescripcion(Mensajes.MSJ_NOT_DATA_FOUND.getProcesoId());
			}else{
				respuestaVO.setCodigoHttp(Codigos.SUCCESS.getProcesoId());
				respuestaVO.setDescripcion(Mensajes.MSJ_SUCCESS.getProcesoId());
			}
			
		}
		respuestaVO.setDepositoVO(depositoVO);
				
		return respuestaVO;
	}

}
