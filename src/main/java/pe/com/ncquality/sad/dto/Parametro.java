package pe.com.ncquality.sad.dto;

import java.io.Serializable;
 

public class Parametro implements Serializable{
	/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private String cnompar;
private String cdescripcion;
 


/**
 * @return the cnompar
 */
public String getCnompar() {
	return cnompar;
}



/**
 * @param cnompar the cnompar to set
 */
public void setCnompar(String cnompar) {
	this.cnompar = cnompar;
}



/**
 * @return the cdescripcion
 */
public String getCdescripcion() {
	return cdescripcion;
}



/**
 * @param cdescripcion the cdescripcion to set
 */
public void setCdescripcion(String cdescripcion) {
	this.cdescripcion = cdescripcion;
}




}
