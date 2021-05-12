// @ts-ignore
import {Injectable} from '@angular/core';
// @ts-ignore
import {HttpClient} from '@angular/common/http';
import {environment} from '../environments/environment';
// @ts-ignore
import {Observable} from 'rxjs';

// @ts-ignore
@Injectable({
  providedIn: 'root'
})
export class HelloWorldService {

  private backendUrl: string;

  constructor(private http: HttpClient) {
    this.backendUrl = `${environment.backendUrl}/hello`;
  }

  getHelloWorld(): Observable<any> {
    // @ts-ignore
    return this.http.get<string>(this.backendUrl, {responseType: 'text'});
  }
}
