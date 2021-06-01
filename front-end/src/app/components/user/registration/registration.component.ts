import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UserService} from '../../../service/user.service';
import {RegistrationValidationService} from './validation/registration-validation.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent implements OnInit {
  registerForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.compose([Validators.required,
        this.validator.patternValidatorEmail()]),
        [this.validator.existingEmailValidator()]],
      password: ['', Validators.compose([Validators.required,
        this.validator.patternValidatorPassword(),
        this.validator.existingEmailValidator()])],
      confirmPassword: ['', [Validators.required]],
    },
    {
      validators: this.validator.MatchPassword('password', 'confirmPassword')
    }
  );
  submitted = false;

  constructor(private userService: UserService,
              private formBuilder: FormBuilder,
              private validator: RegistrationValidationService,
              private route: Router) {
  }

  ngOnInit() {
  }

  get registerFormControl() {
    return this.registerForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    if (this.registerForm.valid) {
      this.userService.addUser(this.registerForm.value).subscribe(data => {
        data = this.registerForm;
        console.log('Your registration has been accepted', data);
        this.route.navigateByUrl('/log');
      });
    }
  }
}

