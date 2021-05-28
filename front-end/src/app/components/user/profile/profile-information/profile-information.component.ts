import {AfterViewInit, Component, OnInit, Output} from '@angular/core';
import {User} from '../../../../model/user';
import {UserService} from '../../../../service/user.service';
import {ActivatedRoute} from '@angular/router';
import {CoachInfo} from '../../../../model/coach-info';
import {AuthenticationService} from '../../../../service/authentication.service';
// @ts-ignore
import EventEmitter = require('events');

@Component({
  selector: 'app-profile-information',
  templateUrl: './profile-information.component.html',
  styleUrls: ['./profile-information.component.css']
})
export class ProfileInformationComponent implements OnInit {
  user: User | undefined;
  id = this.getId();
  // coachInfo: CoachInfo | undefined;

  constructor(private userService: UserService, private route: ActivatedRoute, private auth: AuthenticationService) {
    // @ts-ignore
    this.route.parent.paramMap.subscribe(params => {
      // @ts-ignore
      this.id = params.get('id');
    });
  }

  ngOnInit(): void {
    this.getUser();
   // this.getCoachInfo();
  }

  getUser(): void {
    // @ts-ignore
     this.userService.getUser(this.id).subscribe(user => this.user = user);

  }

  getId(): number | null {
return this.auth.getUserId();
  }



  // getCoachInfo(): void {
  //   // @ts-ignore
  //   // this.userService.getCoachInfo(this.user.coachInfoId).subscribe(coachInfo => this.coachInfo = coachInfo);
  //   this.coachInfo = this.user?.coachInfoDto;
  // }
}
