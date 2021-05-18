import { Component, OnInit } from '@angular/core';
import {User} from '../model/user';
import {UserService} from '../service/user.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-profile-information',
  templateUrl: './profile-information.component.html',
  styleUrls: ['./profile-information.component.css']
})
export class ProfileInformationComponent implements OnInit {
user: User | undefined;
// tslint:disable-next-line:ban-types
email: String;


  constructor(private userService: UserService, private route: ActivatedRoute) {
    this.email = 'adminyoucoach@gmail.com';
  }

  ngOnInit(): void {
    this.getUser();
  }

  getUser(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.userService.getUser(id).subscribe(user => this.user = user);
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.userService.becomeACoach(id).subscribe( data => {
      // @ts-ignore
      data = this.user;
      console.log('You have became a coach', data);
    });
  }
}
