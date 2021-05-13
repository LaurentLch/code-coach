// @ts-ignore
import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
// @ts-ignore
import {HttpClient} from '@angular/common/http';
import {Member} from '../model/Member';

// @ts-ignore
@Injectable({
  providedIn: 'root'
})
export class MemberService {
  private backendUrl: string;
  constructor(private http: HttpClient) {
    this.backendUrl = `${environment.backendUrl}/members`;
  }
  // tslint:disable-next-line:typedef
  addMember(member: Member) {
    return this.http.post(this.backendUrl, member);
  }
}
