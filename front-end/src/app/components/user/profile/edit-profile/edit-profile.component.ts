import {Component, OnInit} from '@angular/core';
import {User} from '../../../../model/user';
import {UserService} from '../../../../service/user.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  user: User | undefined;
  id: number | undefined;

  constructor(private userService: UserService, private route: ActivatedRoute) {
    // @ts-ignore
    this.route.parent.paramMap.subscribe(params => {
      // @ts-ignore
      this.id = params.get('id');
    });
  }

  ngOnInit(): void {
    this.getUser();
  }

  getUser(): void {
    // @ts-ignore
    this.userService.getUser(this.id).subscribe(user => this.user = user);
  }

}
