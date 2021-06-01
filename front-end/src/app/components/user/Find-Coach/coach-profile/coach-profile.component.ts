import {Component, OnInit} from '@angular/core';
import {UserService} from '../../../../service/user.service';
import {ActivatedRoute} from '@angular/router';
import {User} from '../../../../model/user';

@Component({
  selector: 'app-coach-profile',
  templateUrl: './coach-profile.component.html',
  styleUrls: ['./coach-profile.component.css']
})
export class CoachProfileComponent implements OnInit {
  user: User | undefined;
  id: number;

  constructor(private userService: UserService, private route: ActivatedRoute) {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
  }

  ngOnInit(): void {
    this.getUser();
  }

  getUser(): void {
    this.userService.getUser(this.id).subscribe(user => this.user = user);
  }

}
