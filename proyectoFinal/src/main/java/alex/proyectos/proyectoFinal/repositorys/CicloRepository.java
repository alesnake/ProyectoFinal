package alex.proyectos.proyectoFinal.repositorys;

import alex.proyectos.proyectoFinal.modelos.Ciclo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")//permite a localhost de Angular conectar a la REST API
public interface CicloRepository extends CrudRepository<Ciclo, Integer>{


}
