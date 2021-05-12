import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environments/environment';
import {Observable} from 'rxjs';

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
