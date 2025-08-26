
package pe.com.ncquality.sad.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ncquality.sad.entity.TbGrupo;

@Repository ("ncGrupoRepositorio")
public interface NcGrupoRepositorio extends JpaRepository <TbGrupo, Serializable> {
    @Query(value="SELECT g.id_grupo, v_descripcion, b_estado "
           + "FROM tb_grupo g ", nativeQuery = true)
    List<Object[]> obtenerGrupo();
    
}
