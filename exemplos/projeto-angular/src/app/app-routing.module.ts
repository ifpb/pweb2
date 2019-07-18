import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsuariosComponent } from './usuarios.component';
import { UsuariosFormComponent } from './usuarios.form.component';

const routes: Routes = [
  { path: "usuarios", component: UsuariosComponent },
  { path: "usuariosForm", component: UsuariosFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
