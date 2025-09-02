
package pe.com.ncquality.sad.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GenericService {
    
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    // Guardar o actualizar
    public <T, ID> T save(JpaRepository<T, ID> repository, T entity) {
        return repository.save(entity);
    }

        // Buscar por ID y devolver el registro completo
    public <T, ID> T findById(JpaRepository<T, ID> repository, ID id) {
        return repository.findById(id)
                .orElse(null); // devuelve la entidad o null si no existe
    }
    
    // Listar todos
    public <T, ID> List<T> findAll(JpaRepository<T, ID> repository) {
        return repository.findAll();
    }
}
