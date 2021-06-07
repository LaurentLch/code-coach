import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {User} from '../model/user';
import {Observable, of} from 'rxjs';
import {delay, find, map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  backendUrl: any;

  constructor(private http: HttpClient) {
    this.backendUrl = `${environment.backendUrl}`;
  }

  addUser(user: User) {
    return this.http.post(`${this.backendUrl}/security/account`, user);
  }

  editUser(id: number|undefined, user: User | undefined) {
    return this.http.put(`${this.backendUrl}/users/${id}`, user);
  }

  getUser(id: any): Observable<User> {
    const url = `${this.backendUrl}/users/${id}`;
    return this.http.get<User>(url).pipe(map(response => response));
  }

  becomeACoach(id: number) {
    const url = `${this.backendUrl}/users/${id}/become-a-coach`;
    return this.http.post(url, {});
  }

  getUserList(id: number): Observable<User[]> {
    const url = `${this.backendUrl}/users/user-list`;
    return this.http.get<User[]>(url);
  }

  getByEmail(email: string): Observable<any> {
    const url = `${this.backendUrl}/security/account/check-if-account-exists`;
    return this.http.post<User>(url, {email});
  }

  // getCoachInfo(coachInfoId: number |undefined) {
  //   const url = `${this.backendUrl}/coach_infos/${coachInfoId}`;
  //   return this.http.get<CoachInfo>(url).pipe(map(response => response))
  // }

}

