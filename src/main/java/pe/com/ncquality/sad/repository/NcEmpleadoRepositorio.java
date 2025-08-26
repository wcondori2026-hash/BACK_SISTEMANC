
package pe.com.ncquality.sad.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.ncquality.sad.entity.TbEmpleado;


@Repository("ncEmpleadoRepositorio")
public interface NcEmpleadoRepositorio extends JpaRepository <TbEmpleado, Serializable>{
    
    TbEmpleado findAllByIdEmpleadoAndCodEtapa(int idEmpleado , String codEtapa);
            
}
