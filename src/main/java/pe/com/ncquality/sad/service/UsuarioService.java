
package pe.com.ncquality.sad.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.ncquality.sad.bean.PropertiesBean;
import pe.com.ncquality.sad.bean.ResponseUsuario;
import pe.com.ncquality.sad.converter.Convertidor;
import pe.com.ncquality.sad.dto.PersonasDTO;
import pe.com.ncquality.sad.dto.Usuario; 
import pe.com.ncquality.sad.entity.TbPersonas; 

//nuevo ------------------------------------------------------------
import pe.com.ncquality.sad.entity.TbUsuario;
import pe.com.ncquality.sad.repository.NcEmpleadoRepositorio;
import pe.com.ncquality.sad.repository.NcUsuarioRepositorio;
         
import pe.com.ncquality.sad.util.GenericMapper;
import pe.com.ncquality.sad.util.Utilitarios;

@Service("usuarioService")
public class UsuarioService {
        private static String nameClass = UsuarioService.class.getName();
	private static Logger depurador = Logger.getLogger(nameClass);

	@Autowired
	private PropertiesBean propertiesBean;

	 
        
        //-------- nuevo 
        @Autowired 
        @Qualifier("ncUsuarioRepositorio")
        private NcUsuarioRepositorio ncUsuarioRepositorio;
        
        @Autowired
        @Qualifier("ncEmpleadoRepositorio")
        private NcEmpleadoRepositorio ncEmpleadoRepositorio;

        
        
        
        
        
	public ResponseUsuario validarUsuario(String codusu, String clave) {
		depurador.info(":::::::::::::: validarUsuario--->"+nameClass+" ::::::::::::::::");
		ResponseUsuario responseUsuario = new ResponseUsuario();
		Usuario usuario = null;
		try {
			//int cant = usuarioAplicacionRepositorio.countByIdCodUserAndIdCodAplicaAndEsActivo(codusu, "11", "1");
		//	if (cant != 0) {
				TbUsuario data = ncUsuarioRepositorio.findAllByvUsuario(codusu);                                 
				String encriptado = Utilitarios.cifrar(clave, propertiesBean.getSgdSecretKeyPassword());				 
                                //con Tbpersonas
                                if (data != null && data.getvClave().equals(encriptado)) {
					usuario = new Convertidor().convertirUsuario(ncEmpleadoRepositorio.findAllByIdEmpleadoAndCodEtapa(data.getIdEmpleado(), "1"),data.getvUsuario());
					responseUsuario.setCodRespuesta("0000");
					responseUsuario.setUsuario(usuario);
				} else {
					responseUsuario.setCodRespuesta("0002");
					responseUsuario.setDesRespuesta("Usuario o contraseña incorrectos. Verifique sus datos e intente otra vez.");
				}
			//} else {
			//	responseUsuario.setCodRespuesta("0001");
			//	responseUsuario.setDesRespuesta("Por favor verificar el usuario ingresado");
			//}
		} catch (Exception e) {
                    e.printStackTrace();
			responseUsuario.setCodRespuesta("-1");
                        responseUsuario.setDesRespuesta(e.getMessage());
		}
		return responseUsuario;
	}
        public PersonasDTO obtenerUsuario(String codusu) {
		depurador.info(":::::::::::::: obtenerUsuario--->"+nameClass+" ::::::::::::::::"); 
		PersonasDTO usuario = null;
		try {
			 
                                List<Object[]> data = ncUsuarioRepositorio.getTbPersonasBy(codusu);
                                List<PersonasDTO> personas = data.stream().map(obj -> GenericMapper.mapFromObjectArray(obj, PersonasDTO.class)).collect(Collectors.toList());
                                if(personas!=null && personas.size()>0){
                                    usuario=personas.get(0);
                                }
				
		} catch (Exception e) {
                    e.printStackTrace();			 
		}
		return usuario;
	}
	 

}
