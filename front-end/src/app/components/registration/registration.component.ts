// @ts-ignore
import { Component, OnInit } from '@angular/core';
// @ts-ignore
import {FormBuilder, FormGroup} from '@angular/forms';
import {MemberService} from '../../service/member.service';

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

  constructor(private memberService: MemberService, private formBuilder: FormBuilder) {

  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    this.memberService.addMember(this.createRegistrationForm.value).subscribe( data => {
      data = this.createRegistrationForm;
      console.log('Your registration has been accepted', data);
      this.createRegistrationForm.reset();
    });
  }
  ngOnInit(): void {
  }
}
