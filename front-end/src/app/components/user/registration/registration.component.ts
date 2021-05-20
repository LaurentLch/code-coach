// @ts-ignore
import {Component, OnInit} from '@angular/core';
// @ts-ignore
import {FormBuilder, FormGroup} from '@angular/forms';
import {UserService} from '../../../service/user.service';


// @ts-ignore
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

  constructor(private userService: UserService, private formBuilder: FormBuilder) {

  }


  // tslint:disable-next-line:typedef
  onSubmit() {
    this.userService.addUser(this.createRegistrationForm.value).subscribe(data => {
      data = this.createRegistrationForm;
      console.log('Your registration has been accepted', data);
      this.createRegistrationForm.reset();
    });
  }

  ngOnInit(): void {
  }
}

