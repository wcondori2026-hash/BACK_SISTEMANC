package pe.com.ncquality.sad.bean;

import java.io.Serializable;

public class RequestUsuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2204177271799350345L;
	private String username;
	private String password;

	// need default constructor for JSON Parsing
	public RequestUsuario() {
	}

	public RequestUsuario(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
