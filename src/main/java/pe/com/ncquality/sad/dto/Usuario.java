package pe.com.ncquality.sad.dto;

public class Usuario {
	private String codusu;
	private String nombre;
	private String apepat;
	private String apemat;
			
	public Usuario(String codusu, String nombre, String apepat, String apemat) {
		super();
		this.codusu = codusu;
		this.nombre = nombre;
		this.apepat = apepat;
		this.apemat = apemat;
	}
	public String getCodusu() {
		return codusu;
	}
	public void setCodusu(String codusu) {
		this.codusu = codusu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApepat() {
		return apepat;
	}
	public void setApepat(String apepat) {
		this.apepat = apepat;
	}
	public String getApemat() {
		return apemat;
	}
	public void setApemat(String apemat) {
		this.apemat = apemat;
	}
	
	
	
}
