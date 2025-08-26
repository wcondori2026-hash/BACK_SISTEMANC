package pe.com.ncquality.sad.bean;

import java.io.Serializable;
import pe.com.ncquality.sad.dto.Usuario;


public class ResponseUsuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codRespuesta;
	private String desRespuesta;
	private Usuario usuario;
	public String getCodRespuesta() {
		return codRespuesta;
	}
	public void setCodRespuesta(String codRespuesta) {
		this.codRespuesta = codRespuesta;
	}
	public String getDesRespuesta() {
		return desRespuesta;
	}
	public void setDesRespuesta(String desRespuesta) {
		this.desRespuesta = desRespuesta;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
