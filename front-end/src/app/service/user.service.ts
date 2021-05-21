import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {User} from '../model/user';
import {Observable} from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';

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

  getUser(id: number): Observable<User> {
    const url = `${this.backendUrl}/${id}`;
    return this.http.get<User>(url).pipe(map(response => response));
  }


  // tslint:disable-next-line:typedef
  becomeACoach(id: number) {
    const url = `${this.backendUrl}/${id}/become-a-coach`;
    return this.http.post(url, {});
  }
}
