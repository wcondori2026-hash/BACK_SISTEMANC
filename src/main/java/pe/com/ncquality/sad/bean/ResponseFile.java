package pe.com.ncquality.sad.bean;

public class ResponseFile {
	private String mensaje;

	public ResponseFile(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
