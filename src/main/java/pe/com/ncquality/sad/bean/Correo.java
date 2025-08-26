package pe.com.ncquality.sad.bean;

public class Correo {
private String sSubject;
private String nombre;
private String numsol;
private String numexp;
private String[] email;
private String asunto;
private String observacion;

	public String getsSubject() {
		return sSubject;
	}

	public void setsSubject(String sSubject) {
		this.sSubject = sSubject;
	}

	public String getObservacion() {
	return observacion;
}
public void setObservacion(String observacion) {
	this.observacion = observacion;
}
public String getAsunto() {
	return asunto;
}
public void setAsunto(String asunto) {
	this.asunto = asunto;
}

	public String[] getEmail() {
		return email;
	}

	public void setEmail(String[] email) {
		this.email = email;
	}

	public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getNumsol() {
	return numsol;
}
public void setNumsol(String numsol) {
	this.numsol = numsol;
}
public String getNumexp() {
	return numexp;
}
public void setNumexp(String numexp) {
	this.numexp = numexp;
}



}
