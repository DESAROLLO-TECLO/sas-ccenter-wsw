package mx.com.teclo.sas.ccenter.ws.persistencia.hibernate.dao.depostio;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.teclo.sas.ccenter.ws.persistencia.dao.comun.BaseDaoHibernate;
import mx.com.teclo.sas.ccenter.ws.persistencia.hibernate.dto.infraccion.InfraccionDTO;

@Repository
public class DepositoDAOImpl extends BaseDaoHibernate<InfraccionDTO> implements DepositoDAO{

	@Override
	public Long obtenerDepositoIdPorPlacaImpresaNull(String placa) {
		
		Long depositoId =  null;
		
		String hql =  
			     "select i.depId  from InfraccionDTO i,DepositosDTO d WHERE d.depId=i.depId  AND i.infraccImpresa is null"
			     + "  AND i.infraccNum in (select ingr.infracNum from IngresosDTO ingr WHERE ingr.ingrStatus='A')"
			     + " AND i.infraccPlaca=:placa";
	
		
			Query query = getCurrentSession().createQuery(hql);
			query.setParameter("placa", placa);
			
			if(query.uniqueResult()!=null)
				depositoId=(Long)query.uniqueResult();
		
		
		
		return depositoId;
	}

	@Override
	public Long obtenerDepositoIdPorPlacaImpresaNotNull(String placa) {
		
		Long depositoId = null;
		String hql =  
			     "select i.depId  from InfraccionDTO i,DepositosDTO d WHERE d.depId=i.depId  AND i.infraccImpresa is not null"
			     + "  AND i.infraccNum in (select ingr.infracNum from IngresosDTO ingr WHERE ingr.ingrStatus='A')"
			     + " AND infraccPlaca= :placa";
		
			Query query = getCurrentSession().createQuery(hql);
			query.setParameter("placa", placa);
			
			if(query.uniqueResult()!=null)
				depositoId=(Long)query.uniqueResult();
		
		return depositoId;
	}
	
	
	@Override
	public Long obtenerDepositoIdPorInfraccionImpresaNull(String infraccion) {
		
		Long depositoId = null;
		
		String hql =  
			     "select i.depId  from InfraccionDTO i,DepositosDTO d WHERE d.depId=i.depId  AND i.infraccImpresa is null"
			     + "  AND i.infraccNum in (select ingr.infracNum from IngresosDTO ingr WHERE ingr.ingrStatus='A')"
			     + "  AND Fn_Folio_Sancion(i.infraccNum)= :infraccion";
	
		
			Query query = getCurrentSession().createQuery(hql);
			query.setParameter("infraccion", infraccion);
			
			if(query.uniqueResult()!=null)
				depositoId=(Long)query.uniqueResult();
		
		
		
		return depositoId;
	}

	@Override
	public Long obtenerDepositoIdPorInfraccionImpresaNotNull(String infraccion) {
		
		Long depositoId =  null;
		String hql =  
			     "select i.depId  from InfraccionDTO i,DepositosDTO d WHERE d.depId=i.depId  AND i.infraccImpresa is not null"
			     + "  AND i.infraccNum in (select ingr.infracNum from IngresosDTO ingr WHERE ingr.ingrStatus='A')"
			     + " AND Fn_Folio_Sancion(i.infraccNum)= :infraccion";
		
			Query query = getCurrentSession().createQuery(hql);
			query.setParameter("infraccion", infraccion);
			
			if(query.uniqueResult()!=null)
				depositoId=(Long)query.uniqueResult();
		
		return depositoId;
	}
	

}
