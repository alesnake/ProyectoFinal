package alex.proyectos.proyectoFinal.repositorys;

import alex.proyectos.proyectoFinal.modelos.Alumno;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")//permite a localhost de Angular conectar a la REST API
public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {

    Alumno findByNombre(String nombre);

}
