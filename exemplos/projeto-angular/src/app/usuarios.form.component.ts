import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
    templateUrl: "./usuarios.form.component.html",
    selector: "app-usuarios-form"
})
export class UsuariosFormComponent implements OnInit {
    private form:FormGroup;
    ngOnInit(): void {
        this.form = new FormGroup({
            nome: new FormControl('', [Validators.required]),
            idade: new FormControl(0, [Validators.required]),
        });
    }

    processar() {
        if (this.form.valid) {
            console.log(this.form.value);
        } else {
            console.log("Formulario inválido");
        }
    }

}