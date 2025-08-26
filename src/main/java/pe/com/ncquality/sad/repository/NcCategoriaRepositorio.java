
package pe.com.ncquality.sad.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.ncquality.sad.entity.TbCategoria;

@Repository("ncCategoriaRepositorio")
public interface NcCategoriaRepositorio extends JpaRepository <TbCategoria, Serializable> {
    @Query (value="SELECT id_categoria, v_descripcion, b_estado FROM"
            + " tb_categoria", nativeQuery = true)
    List<Object[]> ObtenerCategoria();
    
}
