import { Component, OnInit, OnDestroy } from '@angular/core';
import { UsuariosService } from './usuarios.service';

@Component({
    selector: "app-usuarios",
    templateUrl: "./usuarios.component.html",
    styleUrls: ["./usuarios.component.scss"],
})
export class UsuariosComponent implements OnInit {
    

    constructor(private usuariosService:UsuariosService) {}

    public usuarios;

    public subscribers:any = {};

    ngOnInit(): void {
        this.usuarios = this.usuariosService.getUsuarios().subscribe(usuarios => {
            this.usuarios = usuarios.filter( u => u.type === 'User');
        }, error => {
            console.log("Ocorreu um erro ao tentar listar usuários");
        });
    }

}