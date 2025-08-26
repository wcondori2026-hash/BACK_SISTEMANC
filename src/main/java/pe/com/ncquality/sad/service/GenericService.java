
package pe.com.ncquality.sad.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GenericService {

    // Guardar o actualizar
    public <T, ID> T save(JpaRepository<T, ID> repository, T entity) {
        return repository.save(entity);
    }

    // Buscar por ID
    public <T, ID> Optional<T> findById(JpaRepository<T, ID> repository, ID id) {
        return repository.findById(id);
    }

    // Listar todos
    public <T, ID> List<T> findAll(JpaRepository<T, ID> repository) {
        return repository.findAll();
    }
}
