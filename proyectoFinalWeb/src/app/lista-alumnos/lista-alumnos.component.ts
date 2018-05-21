import { Component, OnInit } from '@angular/core';
import { AlumnoService } from '../alumno.service';

import { Alumno } from '../models/alumno.model';

@Component({
  selector: 'app-lista-alumnos',
  templateUrl: './lista-alumnos.component.html',
  styleUrls: ['./lista-alumnos.component.css']
})
export class ListaAlumnosComponent implements OnInit {

  //array de objetos tipo <any> porque no se sabe que tipo de objetos trae de la BBDD
  alumnos: Alumno[];

  //objeto de tipo AlumnoService, donde se encuentran las llamadas a la API REST
  constructor(private alumnoService: AlumnoService) { }

  //operaciones que realiza al iniciar el componente
  ngOnInit() {
    //consulta la base de datos y guarda todos los alumnos en el Array de tipo <any>
    this.alumnoService.getAll().subscribe(data => {
      this.alumnos = data;
    });
  }

  deleteAlumno(alumno: Alumno): void{
    this.alumnoService.deleteAlumno(alumno).subscribe(data => {
      this.alumnos = this.alumnos.filter(u => u!== alumno);
    });
  }
}
