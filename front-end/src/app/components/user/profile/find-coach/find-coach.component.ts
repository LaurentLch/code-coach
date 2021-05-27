import {Component, OnInit} from '@angular/core';
import {UserService} from '../../../../service/user.service';
import {User} from '../../../../model/user';
import {ActivatedRoute} from '@angular/router';


@Component({
  selector: 'app-find-coach',
  templateUrl: './find-coach.component.html',
  styleUrls: ['./find-coach.component.css']
})
export class FindCoachComponent implements OnInit {
  userList = [
    { firstName: 'Frank', lastName: 'Murphy', email: 'frank.murphy@test.com', role: 'User' },
    { firstName: 'Vic', lastName: 'Reynolds', email: 'vic.reynolds@test.com', role: 'Admin' },
    { firstName: 'Gina', lastName: 'Jabowski', email: 'gina.jabowski@test.com', role: 'Admin' },
    { firstName: 'Jessi', lastName: 'Glaser', email: 'jessi.glaser@test.com', role: 'User' },
    { firstName: 'Jay', lastName: 'Bilzerian', email: 'jay.bilzerian@test.com', role: 'User' }
  ];
  // users: User[]| undefined;
  id: number |undefined;

  constructor(private userService: UserService, private route: ActivatedRoute) {
    // @ts-ignore
    this.route.parent.paramMap.subscribe(params => {
      // @ts-ignore
      this.id = params.get('id');
    });
  }

  ngOnInit(): void {
    this.getUserList();
  }

  getUserList(): void {
    // @ts-ignore
    this.userService.getUserList().subscribe(data => {
      this.userList = data;
    });
  }
}
