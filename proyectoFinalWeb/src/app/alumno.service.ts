import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { Alumno } from './models/alumno.model';

@Injectable()
export class AlumnoService {

  public API = '//localhost:8080';
  public ALUMNO_API = this.API + '/alumnos';

  //un objeto de la clase HttpClient para poder realizar peticiones a la API REST
  constructor(private http: HttpClient) { }

  //llama al servicio de la API REST que consulta todos los alumnos de la BBDD
  getAll(): Observable<any> {
    return this.http.get<Alumno[]>(this.ALUMNO_API + '/all');
  }

  //llama al servicio de la API REST que busca un alumno por ID
  get(id: string){
    return this.http.get(this.ALUMNO_API + '/'+id);
  }

  //llama al servicio de la API REST que añade un alumno nuevo a la BBDD
  createAlumno(alumno){
    return this.http.post<Alumno>(this.ALUMNO_API + '/add', alumno);
  }

    //llama al servicio de la API REST que elimina un alumno de la BBDD
    public deleteAlumno(alumno: Alumno) {
      return this.http.delete(this.ALUMNO_API + "/delete/"+ alumno.idAlumno);
    }
}
