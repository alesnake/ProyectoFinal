//imports Angular
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';

//Componentes o Servicios de Alumno
import { AlumnoService } from './alumno.service';
import { ListaAlumnosComponent } from './lista-alumnos/lista-alumnos.component';
import { AlumnoEditComponent } from './alumno-edit/alumno-edit.component';

//Componentes o Servicios de Ciclo
import { CicloService } from './ciclo.service';

//Componentes o Servicios de Empresa
import { EmpresaService } from './empresa.service';

//rutas para en HTML redireccionar con [routerLink]
const appRoutes: Routes = [
  { path: '', redirectTo: '/lista-alumnos', pathMatch: 'full' },
  {
    path: 'lista-alumnos',
    component: ListaAlumnosComponent
  },
  {
    path: 'alumno-add',
    component: AlumnoEditComponent
  },
  {
    path: 'alumno-edit/:id',
    component: AlumnoEditComponent
  }
];

//donde aparecen todos los compenentes e imports que utiliza Angular para esta App
@NgModule({
  declarations: [
    AppComponent,
    ListaAlumnosComponent,
    AlumnoEditComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [AlumnoService, CicloService, EmpresaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
