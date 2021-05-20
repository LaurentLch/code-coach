import { Component, OnInit } from '@angular/core';
import {User} from '../../../../model/user';


@Component({
  selector: 'app-find-coach',
  templateUrl: './find-coach.component.html',
  styleUrls: ['./find-coach.component.css']
})
export class FindCoachComponent implements OnInit {
  users: User[] = [
    {
      id: 200,
      firstName: 'John',
      lastName: 'Doe',
      email: 'JohnDoe@example.com',
      password: 'testCuss565es',
      role: 'Coach'
    },
    {
      id: 201,
      firstName: 'Jane',
      lastName: 'Doe',
      email: 'JohnDoe@example.com',
      password: 'testCuss565es',
      role: 'Coach'
    }
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
