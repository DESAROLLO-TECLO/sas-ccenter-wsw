package mx.com.teclo.sas.ccenter.ws.util.enums;

public enum Mensajes {

	MSJ_SUCCESS("RESULTADO ENCONTRADO"), MSJ_NOT_DATA_FOUND("NO SE ENCONTRARON RESULTADOS"), MSJ_ERROR_SERVIDOR("ERROR EN EL SERVIDOR"), MSJ_BAD_REQUEST("EL PARAMETRO ES REQUERIDO");
	
	private String mensaje;

	private Mensajes(String mensaje) {
		this.mensaje = mensaje;

	}

	/**
	 * @return the procesoId
	 */
	public String getProcesoId() {
		return mensaje;
	}

	/**
	 * @param procesoId
	 *            the procesoId to set
	 */
	public void setProcesoId(String mensaje) {
		this.mensaje = mensaje;
	}
	
	static Mensajes getArchivoTipo(String x) {
		for (Mensajes currentType : Mensajes.values()) {
	      if (x.equals(currentType.getProcesoId())) {
	        return currentType;
	      }
	    }
	    return null;
	  }
}
