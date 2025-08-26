
package pe.com.ncquality.sad.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.ncquality.sad.entity.TbServicios;

@Repository ("ncServicioRepositorio")
public interface NcServicioRepositorio extends JpaRepository <TbServicios, Serializable>{
    
}
