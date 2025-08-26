package pe.com.ncquality.sad.dto;

public class CorreoDTO {
private String codRespuesta;	
private String correo;
private String clave;


public CorreoDTO(String codRespuesta, String correo, String clave) {
	super();
	this.codRespuesta = codRespuesta;
	this.correo = correo;
	this.clave = clave;
}
public String getCodRespuesta() {
	return codRespuesta;
}
public void setCodRespuesta(String codRespuesta) {
	this.codRespuesta = codRespuesta;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
public String getClave() {
	return clave;
}
public void setClave(String clave) {
	this.clave = clave;
}

}
