import { Component, OnInit } from '@angular/core';
import {UserService} from '../../../../service/user.service';
import {ActivatedRoute} from '@angular/router';
import {User} from '../../../../model/user';

@Component({
  selector: 'app-become-coach',
  templateUrl: './become-coach.component.html',
  styleUrls: ['./become-coach.component.css']
})
export class BecomeCoachComponent implements OnInit {
  // tslint:disable-next-line:ban-types
  email: String;
  user: User | undefined;
  id: number | undefined;

  constructor(private userService: UserService, private route: ActivatedRoute) {
    this.email = 'adminyoucoach@gmail.com';
    // @ts-ignore
    this.route.parent.paramMap.subscribe(params => {this.id = params.get('id'); });
  }

  ngOnInit(): void {
    this.getUser();
  }

  getUser(): void {
    // @ts-ignore
    // const id = Number(this.route.parent.params.get('id'));
    this.userService.getUser(this.id).subscribe(user => this.user = user);
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    // @ts-ignore
    this.userService.becomeACoach(this.id).subscribe( data => {
      // @ts-ignore
      data = this.user;
      console.log('You have became a coach', data);
    });
  }
}
