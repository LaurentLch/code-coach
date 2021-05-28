import {AfterViewInit, Component, OnChanges, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {AuthenticationService} from '../../../service/authentication.service';
import {ProfileInformationComponent} from '../../user/profile/profile-information/profile-information.component';
import {filter, flatMap, map} from 'rxjs/operators';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @ViewChild(ProfileInformationComponent) child: any;


  id: number | null | undefined;

  // @ts-ignore
  constructor(private route: ActivatedRoute, public authenticationService: AuthenticationService) {

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
