package pe.com.ncquality.sad.dto;

public class Combo {
	private String code;
	private String name;
	
	
	public Combo(String codigo, String descripcion) {
		this.code = codigo;
		this.name = descripcion;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
