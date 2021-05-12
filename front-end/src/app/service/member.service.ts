import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Member} from '../model/Member';

@Injectable({
  providedIn: 'root'
})
export class MemberService {
  private backendUrl: string;
  constructor(private http: HttpClient) {
    this.backendUrl = `${environment.backendUrl}`;
  }
  // tslint:disable-next-line:typedef
  addMember(member: Member) {
    return this.http.post(this.backendUrl, member);
  }
}
