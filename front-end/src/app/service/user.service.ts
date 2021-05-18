import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {User} from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  backendUrl: string;
  constructor(private http: HttpClient) {
    this.backendUrl = `${environment.backendUrl}/users`;
  }
  // tslint:disable-next-line:typedef
  addUser(user: User) {
    return this.http.post(this.backendUrl, user);
  }
}
