
package pe.com.ncquality.sad.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.ncquality.sad.dto.PersonasDTO;
import pe.com.ncquality.sad.entity.TbPersonas;
import pe.com.ncquality.sad.entity.TbUsuario;

@Repository("ncUsuarioRepositorio")
public interface NcUsuarioRepositorio extends JpaRepository<TbUsuario , Serializable> {
    
    TbUsuario findByvUsuario (String codUser);
    TbUsuario findAllByvUsuario (String codUser);
    
    @Query (value = "Select p.id_persona,  e.id_empleado, v_num_doc, v_ape_parterno, v_ape_materno, v_nombres_razon, d_fecha_nac, v_nro_cel, v_direccion, p.b_estado, v_correo  from tb_usuario u inner join tb_empleado e on u.id_empleado "
            + "= e.id_empleado inner join tb_personas p on p.id_persona = e.id_persona "
            + "where u.v_usuario = :codUser", nativeQuery = true )
    List<Object[]> getTbPersonasBy (@Param("codUser") String codUser); 
    
}
