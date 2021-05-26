import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {User} from '../model/user';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {CoachInfo} from '../model/coach-info';

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

  getUser(id: number): Observable<User> {
    const url = `${this.backendUrl}/users/${id}`;
    return this.http.get<User>(url).pipe(map(response => response));
  }

  becomeACoach(id: number) {
    const url = `${this.backendUrl}/users/${id}/become-a-coach`;
    return this.http.post(url, {});
  }

  // getCoachInfo(coachInfoId: number |undefined) {
  //   const url = `${this.backendUrl}/coach_infos/${coachInfoId}`;
  //   return this.http.get<CoachInfo>(url).pipe(map(response => response))
  // }
}

