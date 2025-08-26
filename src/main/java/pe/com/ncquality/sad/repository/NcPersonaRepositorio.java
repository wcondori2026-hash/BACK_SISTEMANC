
package pe.com.ncquality.sad.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.ncquality.sad.entity.TbPersonas;

@Repository("ncPersonaRepositorio")
public interface NcPersonaRepositorio extends JpaRepository <TbPersonas, Serializable>{
    
    
}
