package pe.com.ncquality.sad.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtDTO {
    private String token;
    private String codRespuesta;
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> authorities;
    
    public JwtDTO(String token, String codRespuesta, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.codRespuesta = codRespuesta;
        this.nombreUsuario = nombreUsuario;
        this.authorities = authorities;
    }

    public String getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(String codRespuesta) {
        this.codRespuesta = codRespuesta;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
