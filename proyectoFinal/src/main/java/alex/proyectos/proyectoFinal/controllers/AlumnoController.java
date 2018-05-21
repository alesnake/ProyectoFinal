package alex.proyectos.proyectoFinal.controllers;

import alex.proyectos.proyectoFinal.modelos.Alumno;
import alex.proyectos.proyectoFinal.repositorys.AlumnoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Controlador con todos los servicios de la REST API para trabajar con los datos de los alumnos
 * @author alex
 */
@Controller
@RequestMapping(path = "/alumnos")//URL principal
public class AlumnoController {

    @Autowired
    private AlumnoRepository repository;

    /**
     * Consulta la tabla alumno de la BBDD
     * @return lista con todos los Alumnos
     */
    @GetMapping(path = "/all")//URL a la que se accede para hacer la consulta a la BBDD
    @CrossOrigin(origins = "http://localhost:4200")//permite a Angular conectar a la REST API
    public @ResponseBody Iterable<Alumno> getAlumnos(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody
    Optional<Alumno> getAlumno(@PathVariable("id") Integer id){
        return repository.findById(id);
    }

    /*@GetMapping(path = "/name/{nombre}")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody
    Alumno getAlumnoNombre(@PathVariable("nombre") String nombre){
        return repository.findByNombre(nombre);
    }*/

    /*
    /**
     * Añade un nuevo alumno a la BBDD
     * @param nombre
     * @param apellidos
     * @param email
     * @param username
     * @param pass
     * @param idEmpresaAux
     * @param idCicloAux
     * @return String con valor "Saved"

    @GetMapping(path = "/add")//URL a la que se accede para añadir un alumno a la BBDD
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody String addAlumno(@RequestParam String nombre, @RequestParam String apellidos, @RequestParam String email,
                                          @RequestParam String username, @RequestParam String pass, @RequestParam int idEmpresaAux,
                                          @RequestParam int idCicloAux){

        Alumno a = new Alumno();

        a.setNombre(nombre);
        a.setApellidos(apellidos);
        a.setEmail(email);
        a.setUsername(username);
        a.setPass(pass);
        a.setAdmin(0);
        a.setIdEmpresaAux(idEmpresaAux);
        a.setIdCicloAux(idCicloAux);

        repository.save(a);

        return "Saved";
    }*/

    @PostMapping(path = "/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody Alumno crearAlumno(@RequestBody Alumno alumno){
        return repository.save(alumno);
    }

    @DeleteMapping(path = {"/delete/{id}"})
    @CrossOrigin(origins = "http://localhost:4200")
    @Transactional
    public @ResponseBody
    void borrarAlumno(@PathVariable("id")Integer id){
        repository.deleteById(id);
    }


}
