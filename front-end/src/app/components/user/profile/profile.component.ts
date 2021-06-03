import {Component, OnInit} from '@angular/core';
import {User} from '../../../model/user';
import {UserService} from '../../../service/user.service';
import {ActivatedRoute} from '@angular/router';
import {AuthenticationService} from '../../../service/authentication.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {


  user: User | undefined;
  userList: User[] | undefined;


  constructor(private userService: UserService, private route: ActivatedRoute, public authenticationService: AuthenticationService) {
  }

  ngOnInit(): void {
    this.getUser();
    this.getUserList();
  }

  getUser(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.userService.getUser(id).subscribe(user => this.user = user);
  }

  getUserList(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.userService.getUserList(id).subscribe(userList => this.userList = userList);
  }


}
