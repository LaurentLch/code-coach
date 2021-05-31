import {Component, OnInit} from '@angular/core';

import {FormBuilder} from '@angular/forms';
import {UserService} from '../../../service/user.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent implements OnInit {
  createRegistrationForm = this.formBuilder.group({
    firstName: '',
    lastName: '',
    email: '',
    password: ''
  });

  constructor(private userService: UserService,
              private formBuilder: FormBuilder,
              private route: Router) {
  }


  onSubmit() {
    this.userService.addUser(this.createRegistrationForm.value).subscribe(data => {
      data = this.createRegistrationForm;
      console.log('Your registration has been accepted', data);
      this.route.navigateByUrl('/log');
    });
  }

  ngOnInit(): void {
  }
}



