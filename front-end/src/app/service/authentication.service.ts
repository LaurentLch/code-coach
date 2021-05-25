import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';
// @ts-ignore
import * as JWT from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private tokenKey = 'jwt_token';
  private usernameKey = 'username';
  private userLoggedInSource = new Subject<boolean>();

  userLoggedIn$ = this.userLoggedInSource.asObservable();

  constructor() {
  }

  public setJwtToken(token: string): void {
    sessionStorage.setItem(this.tokenKey, token);
  }

  getToken() {
    return sessionStorage.getItem(this.tokenKey);
  }

  getUserId() {
    if (!this.isLoggedIn()) {
      return null;
    }
    return JWT(this.getToken()).id;
  }

  isLoggedIn() {
    return sessionStorage.getItem(this.tokenKey) !== null;
  }

  logout() {
    sessionStorage.removeItem(this.tokenKey);
    this.userLoggedInSource.next(false);
  }

  isCoach(): boolean {
    if (!this.isLoggedIn()) {
      return false;
    }
    const tokenDecoded: any = JWT(this.getToken());
    return tokenDecoded.rol.includes('COACH');
  }

  isAdmin(): boolean {
    if (!this.isLoggedIn()) {
      return false;
    }
    const tokenDecoded: any = JWT(this.getToken());
    return tokenDecoded.rol.includes('ADMIN');
  }

  getUsername() {
    return sessionStorage.getItem(this.usernameKey);
  }
}
