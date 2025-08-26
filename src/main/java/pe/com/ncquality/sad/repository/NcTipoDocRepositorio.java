
package pe.com.ncquality.sad.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ncquality.sad.dto.ObjetoDTO;
import pe.com.ncquality.sad.entity.TbTipoDoc;

@Repository ("ncTipoDocRepositorio")
public interface NcTipoDocRepositorio extends JpaRepository <TbTipoDoc, Serializable>{
    
    @Query(value="SELECT td.id_tipo_doc, td.v_descripcion, td.b_estado "
           + "FROM tb_tipo_doc td ", nativeQuery = true)
    List<Object[]> obtenerDocumentos();
    
    @Query(value = "SELECT * FROM tb_tipo_doc LIMIT 3", nativeQuery = true)
    List<TbTipoDoc> findOnlyTipoDoc();
    
    
}
