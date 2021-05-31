import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UserService} from '../../../service/user.service';
import {RegistrationValidationService} from './validation/registration-validation.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;

  constructor(private userService: UserService,
              private formBuilder: FormBuilder,
              private validator: RegistrationValidationService) {}

  ngOnInit(){
    this.registerForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.compose([Validators.required, this.validator.patternValidator()])],
      confirmPassword: ['', [Validators.required]],
    },
      {
        validator: this.validator.MatchPassword('password', 'confirmPassword')
      }
    );
  }

  get registerFormControl() {
    return this.registerForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    if (this.registerForm.valid) {
      alert('Thanks for registering!');
      this.userService.addUser(this.registerForm.value).subscribe(data => {
        data = this.registerForm;
        console.log('Your registration has been accepted', data);
        this.registerForm.reset();
      });
    }
  }
}

