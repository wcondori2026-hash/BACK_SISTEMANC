
package pe.com.ncquality.sad.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.ncquality.sad.entity.TbCodigos;

@Repository ("ncCodigosRepositorio")
public interface NcCodigosRepositorio extends JpaRepository <TbCodigos, Serializable> {
    
    @Query(value = "Select c.id_codigo, c.v_cod_tipo, v_descripcion, v_descr_corta, b_estado, v_tipo"
            + " FROM tb_codigos c"
            + " WHERE c.v_tipo = :tipo"
            + " ORDER BY c.v_cod_tipo ", nativeQuery = true)
    List<TbCodigos> ObtenerListaByTipo(@Param("tipo") String tipo);
}
