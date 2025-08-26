
package pe.com.ncquality.sad.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ncquality.sad.entity.TbTipoPersona;


@Repository ("ncTipoPersonaRepositorio")
public interface NcTipoPersonaRepositorio extends JpaRepository <TbTipoPersona, Serializable> {
    @Query(value="SELECT tp.id_tipo_pers, v_descripcion, b_estado "
           + "FROM tb_tipo_persona tp ", nativeQuery = true)
    List<Object[]> obtenerTipoPersona();
    
}
