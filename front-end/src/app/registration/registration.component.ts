import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {MemberService} from '../service/member.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  createRegistrationForm = this.formBuilder.group({
    firstname: '',
    lastname: '',
    email: '',
    password: ''
  });
  constructor(private memberService: MemberService, private formBuilder: FormBuilder) {}
  onSubmit(): void{
    this.memberService.addMember(this.createRegistrationForm.value).subscribe(data => {
      data = this.createRegistrationForm;
      alert('Registration successful');
      this.createRegistrationForm.reset();
    });
  }
  ngOnInit(): void {
  }
}
