import {Component, OnInit} from '@angular/core';
import {User} from '../../../../model/user';
import {UserService} from '../../../../service/user.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, Validators} from '@angular/forms';
import {RegistrationValidationService} from '../../registration/validation/registration-validation.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  editForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.compose([Validators.required,
        this.validator.patternValidatorEmail()])],
      password: ['', Validators.compose([Validators.required,
        this.validator.patternValidatorPassword()])],
      confirmPassword: ['', [Validators.required]],
    },
    {
      validators: this.validator.MatchPassword('password', 'confirmPassword')
    }
  );

  submitted = false;

  user: User | undefined;
  id: number | undefined;
  buttonName: any = 'Edit';

  constructor(private userService: UserService, private route: ActivatedRoute, private formBuilder: FormBuilder,
              private validator: RegistrationValidationService,
              private router: Router) {
    // @ts-ignore
    this.route.parent.paramMap.subscribe(params => {
      // @ts-ignore
      this.id = params.get('id');
    });
  }

  ngOnInit(): void {
    this.getUser();
  }

  get editFormControl() {
    return this.editForm.controls;
  }

  onSubmit() {
    console.log('succes1');
    this.submitted = true;
    if (this.editForm.valid) {
      console.log('succes2')
      this.userService.editUser(this.id, this.editForm.value).subscribe(data => {
        data = this.editForm;
        console.log('Your registration has been accepted', data);
      });
      const partOne = document.getElementById('detailsInPlainText');
      const partTwo = document.getElementById('detailsInForm');

      // @ts-ignore
      partOne.style.display = 'block';
      // @ts-ignore
      partTwo.style.display = 'none';

      this.buttonName = 'Edit';
    } else {
      console.log('fail2')
    }
  }

  getUser(): void {
    this.userService.getUser(this.id).subscribe(user => this.user = user);
  }

  editUser(): void {
    this.userService.editUser(this.id, this.user).subscribe(user => {
      // @ts-ignore
      return this.user = user;
    })
  }

  editProfile() {
    const partOne = document.getElementById('detailsInPlainText');
    const partTwo = document.getElementById('detailsInForm');

    // @ts-ignore
    partOne.style.display = 'none';
    // @ts-ignore
    partTwo.style.display = 'block';

    this.buttonName = 'Save';
  }

}
