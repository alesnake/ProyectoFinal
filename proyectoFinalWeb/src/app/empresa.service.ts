import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class EmpresaService {

  public API = '//localhost:8080';
  public EMPRESA_API = this.API + '/empresas';

  //un objeto de la clase HttpClient para poder mandar peticiones a la API REST
  constructor(private http: HttpClient) { }

  //llama al servicio de la API REST que consulta todas las empresas de la BBDD
  getAll(): Observable<any>{
    return this.http.get(this.EMPRESA_API + '/all');
  }

}
