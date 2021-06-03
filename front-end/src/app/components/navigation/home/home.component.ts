import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../../../service/authentication.service';
import {filter, map} from 'rxjs/operators';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  id: number | null | undefined;

  constructor(public authenticationService: AuthenticationService) {
  }

  ngOnInit(): void {
    if (this.authenticationService.getUserId()) {
      this.id = this.authenticationService.getUserId();
    }


    this.authenticationService.userLoggedIn$
      .pipe(
        filter(loggedIn => loggedIn),
        map(_ => this.authenticationService.getUserId())
      ).subscribe(id => this.id = id);

  }


  // @ts-ignore
  getId(): void {
    this.id = this.authenticationService.getUserId();
    console.log(this.id);
  }
}
