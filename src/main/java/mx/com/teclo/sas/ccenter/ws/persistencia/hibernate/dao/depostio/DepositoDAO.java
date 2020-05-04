package mx.com.teclo.sas.ccenter.ws.persistencia.hibernate.dao.depostio;

public interface DepositoDAO {
	
	public Long obtenerDepositoIdPorPlacaImpresaNull(String placa);
	
	public Long obtenerDepositoIdPorPlacaImpresaNotNull(String placa);
	
	public Long obtenerDepositoIdPorInfraccionImpresaNull(String infraccion);
	
	public Long obtenerDepositoIdPorInfraccionImpresaNotNull(String infraccion);

}
