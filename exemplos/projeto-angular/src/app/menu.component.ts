import { Component } from '@angular/core';

@Component({
    templateUrl: "./menu.component.html",
    styleUrls: ["./menu.component.scss"],
    selector: "app-menu",
})
export class MenuComponent{ 
    public items = [
        { nome : "Página Inicial"},
        { nome : "Perfil"}
    ];
}