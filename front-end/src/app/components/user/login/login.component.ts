import {Component, OnInit} from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {Router} from "@angular/router";
import {SecurityService} from "../../../service/security.service";
import {AuthenticationService} from "../../../service/authentication.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm = this.formBuilder.group({
    username: '',
    password: ''
  });

  constructor(private securityService: SecurityService,
              private formBuilder: FormBuilder,
              private route: Router,
              private authenticationService: AuthenticationService
  ) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.securityService.login(this.loginForm.value)
      .subscribe(_ => {
        const userId = 1;
        return this.route.navigateByUrl(`user/${this.authenticationService.getUserId()}/profile-information`);
      });
  }

}
