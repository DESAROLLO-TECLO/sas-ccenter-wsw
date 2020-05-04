package mx.com.teclo.sas.ccenter.ws.persistencia.hibernate.dao.infraccion;

import mx.com.teclo.sas.ccenter.ws.persistencia.dao.comun.BaseDao;
import mx.com.teclo.sas.ccenter.ws.persistencia.hibernate.dto.infraccion.VinfraccionesDTO;

public interface InfraccionDAO extends BaseDao<VinfraccionesDTO>{

	
	 public Integer obtenerNumeroInfraccionesPorPlaca(String placa);
	
}
