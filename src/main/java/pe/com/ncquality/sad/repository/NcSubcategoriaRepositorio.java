
package pe.com.ncquality.sad.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ncquality.sad.entity.TbSubcategoria;


@Repository ("ncSubcategoriaRepositorio")
public interface NcSubcategoriaRepositorio extends JpaRepository <TbSubcategoria, Serializable>{
    @Query (value="SELECT id_subcateg, v_descripcion, b_estado FROM"
            + " tb_Subcategoria", nativeQuery = true)
    List<Object[]> ObtenerSubcategoria();
    
}
