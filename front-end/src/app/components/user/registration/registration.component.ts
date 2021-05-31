import {Component, OnInit} from '@angular/core';

import {FormBuilder, FormGroup} from '@angular/forms';
import {UserService} from '../../../service/user.service';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../../service/authentication.service';


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

  loginForm = this.formBuilder.group({
    email: '',
    password: ''
  });


  constructor(private userService: UserService,
              private formBuilder: FormBuilder,
              private route: Router,
              private authenticationService: AuthenticationService) {
  }


  onSubmit() {
    this.userService.addUser(this.createRegistrationForm.value).subscribe(data => {
      data = this.createRegistrationForm;
      console.log('Your registration has been accepted', data);
      this.authenticationService.logIn(this.loginForm.value);
      this.route.navigateByUrl(`/home`);
      // this.route.navigateByUrl(`user/${this.authenticationService.getUserId()}/profile-information`);
      // this.route.navigateByUrl('/log');
    });
  }

  ngOnInit(): void {
  }
}



