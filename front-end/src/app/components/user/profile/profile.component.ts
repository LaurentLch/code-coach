import {Component, OnInit} from '@angular/core';
import {User} from '../../../model/user';
import {UserService} from '../../../service/user.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {


  user: User | undefined;

  // users: User[] = [
  //   {
  //     id: 1,
  //     firstName: 'JeanClaude',
  //     lastName: 'VanDamme',
  //     email: 'JCVD@gmail.com ',
  //     password: 'Hello1234',
  //     role: 'COACH',
  //   },
  //   {
  //     id: 1,
  //     firstName: 'JeanneClaude',
  //     lastName: 'VanDamme',
  //     email: 'JCVD@gmail.com ',
  //     password: 'Hello1234',
  //     role: 'COACH',
  //   },
  //   {
  //     id: 1,
  //     firstName: 'Jean',
  //     lastName: 'Dupont',
  //     email: 'JCVD@gmail.com ',
  //     password: 'Hello1234',
  //     role: 'COACH',
  //   }
  // ];

  constructor(private userService: UserService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.getUser();
  }

  getUser(): void {
    // @ts-ignore
    // const id = Number(this.route.parent.params.get('id'));
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.userService.getUser(id).subscribe(user => this.user = user);
  }
}
