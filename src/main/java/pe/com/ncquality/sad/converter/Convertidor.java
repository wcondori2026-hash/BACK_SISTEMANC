package pe.com.ncquality.sad.converter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


import pe.com.ncquality.sad.dto.Combo; 
import pe.com.ncquality.sad.dto.Usuario;
//nuevo -- NCQuality
import pe.com.ncquality.sad.entity.TbEmpleado;
import pe.com.ncquality.sad.entity.TbPersonas;

@Component("convertidor")
public class Convertidor {
	 
    public Usuario convertirUsuario(TbEmpleado empleado, String codusu) {
		Usuario usuario = new Usuario(
				codusu, 
				empleado.getTbPersonas().getvNombRazon(), 
				empleado.getTbPersonas().getvApelPaterno(), 
				empleado.getTbPersonas().getvApelMaterno());
		return usuario;
	}

         
}
