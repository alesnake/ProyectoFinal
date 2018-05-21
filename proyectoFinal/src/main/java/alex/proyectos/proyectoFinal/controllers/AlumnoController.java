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

    @GetMapping(path = "/empresa/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody
    Iterable<Alumno> getAlumnoByEmpresa(@PathVariable("id") Integer id){
        return repository.findByIdEmpresaAux(id);
    }

    @GetMapping(path = "/ciclo/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody
    Iterable<Alumno> getAlumnoByCiclo(@PathVariable("id") Integer id){
        return repository.findByIdCicloAux(id);
    }

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
