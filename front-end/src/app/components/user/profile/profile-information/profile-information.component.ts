import {Component, OnInit} from '@angular/core';
import {User} from '../../../../model/user';
import {UserService} from '../../../../service/user.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-profile-information',
  templateUrl: './profile-information.component.html',
  styleUrls: ['./profile-information.component.css']
})
export class ProfileInformationComponent implements OnInit {

  user: User | undefined;
  id: number | undefined;
  // coachInfo: CoachInfo | undefined;

  constructor(private userService: UserService, private route: ActivatedRoute) {
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

  // getCoachInfo(): void {
  //   // @ts-ignore
  //   // this.userService.getCoachInfo(this.user.coachInfoId).subscribe(coachInfo => this.coachInfo = coachInfo);
  //   this.coachInfo = this.user?.coachInfoDto;
  // }
}
