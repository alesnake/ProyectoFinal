import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';

//Servicios
import { AlumnoService } from '../alumno.service';
import { CicloService } from '../ciclo.service';
import { EmpresaService } from '../empresa.service';

@Component({
  selector: 'app-alumno-edit',
  templateUrl: './alumno-edit.component.html',
  styleUrls: ['./alumno-edit.component.css']
})
export class AlumnoEditComponent implements OnInit, OnDestroy {

  alumno: any = {};

  sub: Subscription;

  ciclos: Array<any>;

  empresas: Array<any>

  constructor(private route: ActivatedRoute,
    private router: Router,
    private alumnoService: AlumnoService,
    private cicloService: CicloService,
    private empresaService: EmpresaService) { }

  ngOnInit() {
    this.cicloService.getAll().subscribe(data => {
      this.ciclos = data;
    });

    this.empresaService.getAll().subscribe(data => {
      this.empresas = data;
    });

    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];

      if(id){
        this.alumnoService.get(id).subscribe((alumno: any) => {
          if(alumno){
            this.alumno = alumno;
            this.alumno.href = alumno._links.self.href;
          }
          else{
            console.log('El alumno no existe');
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy(){

  }

  gotoList(){
    this.router.navigate(['/lista-alumnos']);
  }

  createAlumno(): void{
    this.alumnoService.createAlumno(this.alumno).subscribe( result => {
      this.gotoList();
    });
  }
}
