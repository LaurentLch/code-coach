import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  backendUrl: any;

  constructor(private http: HttpClient) {
    this.backendUrl = `${environment.backendUrl}/security`;
  }

  login(login: any) {
    return this.http.post(`${this.backendUrl}/login`, login);
  }
}
