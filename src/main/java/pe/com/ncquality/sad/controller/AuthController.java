package pe.com.ncquality.sad.controller;

import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import pe.com.ncquality.sad.bean.Mensaje;
import pe.com.ncquality.sad.bean.ResponseUsuario;
import pe.com.ncquality.sad.dto.JwtDTO;
import pe.com.ncquality.sad.dto.PersonasDTO;
import pe.com.ncquality.sad.service.JwtUserDetailsService;
import pe.com.ncquality.sad.service.UsuarioService;
import pe.com.ncquality.sad.util.JwtTokenUtil;

@RestController
@Api( tags = "Autenticacion")
@RequestMapping("/v1/auth") 
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {
	private static Logger depurador = Logger.getLogger(AuthController.class.getName());
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
	UsuarioService usuarioService;	
        
	@ApiOperation(value = "Este metodo es utilizado para obtener el listado de los ubigeos.")
	@RequestMapping(value = "/getLogin", method = RequestMethod.POST)
	public ResponseEntity<?> validarUsuario(@RequestBody Map<String, Object> usuario) {
        depurador.info(":::::::::::::::::::: validarUsuario :::::::::::::::::::::::::");
        try {
            // Validaciones básicas
            String nombreUsuario = usuario.get("usuario").toString().toUpperCase();
            String clave = usuario.get("clave").toString();

            ResponseUsuario responseUsuario = usuarioService.validarUsuario(nombreUsuario, clave);
            String codigoRespuesta = responseUsuario.getCodRespuesta();
            if ("0000".equals(codigoRespuesta)) {
                // Autenticación y generación del token
                depurador.info(":::::::::::::::::::: createAuthenticationToken WECM :::::::::::::::::::::::::");
                UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);
                PersonasDTO usuariodata = usuarioService.obtenerUsuario(nombreUsuario);
                String token = jwtTokenUtil.generateToken(userDetails,usuariodata);
                depurador.info("TOKEN ==> " + token);
                JwtDTO jwtDTO = new JwtDTO(token, codigoRespuesta, userDetails.getUsername(), userDetails.getAuthorities());
                return ResponseEntity.ok(jwtDTO);
            } else {
                // Respuesta cuando el código no es exitoso
                return ResponseEntity.ok(responseUsuario);
            }
         
    } catch (Exception e) {
        depurador.error("Error al validar usuario: ", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Ocurrió un error interno al procesar la solicitud.");
    }
}

	@ApiOperation(value = "Este metodo es utilizado para obtener el listado de los ubigeos.")
	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<?> token() throws Exception {
		depurador.info(":::::::::::::::::::: validarUsuario :::::::::::::::::::::::::" );                
		//ResponseUsuario responseUsuario = new ResponseUsuario();
                //Map<String, Object>  usuario = new Map<String, Object>();
                
		//responseUsuario = usuarioService.validarUsuario(usuario.get("usuario").toString().toUpperCase(), usuario.get("clave").toString());
                
                depurador.info(":::::::::::::::::::: createAuthenticationToken WECM :::::::::::::::::::::::::");
		String message = "0000";		 
		if(message.equals("0000")) {
			final UserDetails userDetails = userDetailsService.loadUserByUsername("MPDE");
			final String token = jwtTokenUtil.generateToken(userDetails,null);
			depurador.info("TOKEN ==>" + token);
			JwtDTO jwtDTO = new JwtDTO(token,message, userDetails.getUsername(), userDetails.getAuthorities());
			return new ResponseEntity<JwtDTO>(jwtDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
                //depurador.info(":::::::::::::::::::: FIN createAuthenticationToken WECM :::::::::::::::::::::::::");
		//return new ResponseEntity<ResponseUsuario>(responseUsuario, HttpStatus.OK);
	}
	@ApiOperation(value = "Este metodo es utilizado para obtener el listado de parametros.")
	@RequestMapping(value = "/actualizarClave", method = RequestMethod.POST)
	public ResponseEntity<?> actualizarClave(@RequestBody Map<String, Object>  clave) throws Exception {
		depurador.info(":::::::::::::::::::: actualizarClave :::::::::::::::::::::::::" + clave.get("codusu").toString());	
		String codRespuesta = "";
		Mensaje msj = new Mensaje();
		//codRespuesta = usuarioService.actualizarClave(clave.get("codusu").toString().toUpperCase(), clave.get("clave").toString().toUpperCase());
		msj.setCodRespuesta(codRespuesta);
		return new ResponseEntity<Mensaje>(msj, HttpStatus.OK);
	}
	
}
