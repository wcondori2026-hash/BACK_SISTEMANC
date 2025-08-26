
package pe.com.ncquality.sad.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.ncquality.sad.entity.TbTipoProducto;


@Repository ("ncTipoProductoRepositorio")
public interface NcTipoProductoRepositorio extends JpaRepository <TbTipoProducto, Serializable> {
    
}
