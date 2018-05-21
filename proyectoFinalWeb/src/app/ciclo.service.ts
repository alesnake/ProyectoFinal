import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class CicloService {

  public API = '//localhost:8080';
  public CICLO_API = this.API + '/ciclos';

  //un objeto de la clase HttpClient para poder mandar peticiones a la API REST
  constructor(private http: HttpClient) { }

  //llama al servicio de la API REST que consulta todos los ciclos de la BBDD
  getAll(): Observable<any> {
    return this.http.get(this.CICLO_API + '/all');
  }

}
