import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter } from 'rxjs/operators';

@Injectable({providedIn: 'root'})
export class UsuariosService {

    apiUrl = "https://api.github.com/users";

    constructor(private httpClient:HttpClient) {
    }

    getUsuarios():Observable<any[]> {
        return this.httpClient.get<any[]>(this.apiUrl);
    }

    salvarUsuario(usuario) {
        return this.httpClient.post(this.apiUrl, usuario);
    }

}