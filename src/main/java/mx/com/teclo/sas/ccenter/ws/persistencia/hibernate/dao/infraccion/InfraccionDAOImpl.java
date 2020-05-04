package mx.com.teclo.sas.ccenter.ws.persistencia.hibernate.dao.infraccion;


import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.teclo.sas.ccenter.ws.persistencia.dao.comun.BaseDaoHibernate;
import mx.com.teclo.sas.ccenter.ws.persistencia.hibernate.dao.infraccion.InfraccionDAO;
import mx.com.teclo.sas.ccenter.ws.persistencia.hibernate.dto.infraccion.VinfraccionesDTO;
import mx.com.teclo.sas.ccenter.ws.persistencia.vo.respuesta.DepositoVO;

@Repository
public class InfraccionDAOImpl extends BaseDaoHibernate<VinfraccionesDTO> implements InfraccionDAO{
	
	/**
     * {@inheritDoc}
     */
    @Override
    public Integer obtenerNumeroInfraccionesPorPlaca(String placa) {
    	Integer numInfracciones=null;
    	
    				Criteria c= getCurrentSession().createCriteria(VinfraccionesDTO.class)
    		        .add(Restrictions.eq("placa", placa))
    		        .add(Restrictions.eq("infracPagada", "N"));
    				numInfracciones=c.list().size();
    	
		return numInfracciones;
    }
    

}
