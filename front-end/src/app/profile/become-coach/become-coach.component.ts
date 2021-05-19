import { Component, OnInit } from '@angular/core';
import {UserService} from '../../service/user.service';
import {ActivatedRoute} from '@angular/router';
import {User} from '../../model/user';

@Component({
  selector: 'app-become-coach',
  templateUrl: './become-coach.component.html',
  styleUrls: ['./become-coach.component.css']
})
export class BecomeCoachComponent implements OnInit {
  // tslint:disable-next-line:ban-types
  email: String;
  user: User | undefined;

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
