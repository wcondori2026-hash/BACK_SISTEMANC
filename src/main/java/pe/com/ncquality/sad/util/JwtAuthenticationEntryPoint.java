package pe.com.ncquality.sad.util;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
		    System.out.println(":::::::::::::::::::: 0002 ::::::::::::::::::");
		    String expired = (String) request.getAttribute("expired");
		    String nofound = (String) request.getAttribute("nofound");
		    	       
	        if (expired!=null){
	        	response.sendError(HttpServletResponse.SC_UNAUTHORIZED,expired);
	        }else if (nofound!=null){
	        	response.sendError(HttpServletResponse.SC_UNAUTHORIZED, nofound);
	        }else {
	        	response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No esta autorizado");
	        }
	}
}
