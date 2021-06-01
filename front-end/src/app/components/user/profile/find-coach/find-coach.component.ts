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
  userList: User[] | undefined;
  id: number | undefined;
  email: any;

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
