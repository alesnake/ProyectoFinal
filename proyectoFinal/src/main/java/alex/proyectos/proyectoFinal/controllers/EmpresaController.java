package alex.proyectos.proyectoFinal.controllers;


import alex.proyectos.proyectoFinal.modelos.Empresa;
import alex.proyectos.proyectoFinal.repositorys.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/empresas")//URL principal
public class EmpresaController {

    @Autowired
    EmpresaRepository repository;

    @GetMapping(path = "/all")//URL a la que se accede para hacer la consulta a la BBDD
    @CrossOrigin(origins = "http://localhost:4200")//permite a Angular conectar a la REST API
    public @ResponseBody Iterable<Empresa> getEmpresas(){
        return repository.findAll();
    }
}
