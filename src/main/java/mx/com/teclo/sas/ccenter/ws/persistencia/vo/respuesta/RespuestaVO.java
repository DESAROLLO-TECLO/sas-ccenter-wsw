package mx.com.teclo.sas.ccenter.ws.persistencia.vo.respuesta;

import mx.com.teclo.sas.ccenter.ws.persistencia.vo.respuesta.DepositoVO;

public class RespuestaVO {
	
	private String codigoHttp;
	private String descripcion;
	private DepositoVO depositoVO;
	private SancionesVO sancionesVO;
	public String getCodigoHttp() {
		return codigoHttp;
	}
	public void setCodigoHttp(String codigoHttp) {
		this.codigoHttp = codigoHttp;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public DepositoVO getDepositoVO() {
		return depositoVO;
	}
	public void setDepositoVO(DepositoVO depositoVO) {
		this.depositoVO = depositoVO;
	}
	public SancionesVO getSancionesVO() {
		return sancionesVO;
	}
	public void setSancionesVO(SancionesVO sancionesVO) {
		this.sancionesVO = sancionesVO;
	}

}
