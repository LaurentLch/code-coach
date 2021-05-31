import {Injectable} from '@angular/core';
import {AbstractControl, AsyncValidatorFn, ValidatorFn} from '@angular/forms';
import {Observable, of} from 'rxjs';
import {map, debounceTime, take, switchMap} from 'rxjs/operators';
import {UserService} from '../../../../service/user.service';


@Injectable({
  providedIn: 'root'
})
export class RegistrationValidationService {

  constructor(private userService: UserService) {
  }

  patternValidatorEmail(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } | null => {
      if (!control.value) {
        return null;
      }
      const regex = new RegExp('^(([^<>()\\[\\]\\\\.,;:\\s@"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@"]+)*)|(".+"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$');
      const valid = regex.test(control.value);
      return valid ? null : {invalidEmail: true};
    };
  }

  existingEmailValidator(initialEmail: string = ''): AsyncValidatorFn {
    return (
      control: AbstractControl
    ):
      | Promise<{ [key: string]: any } | null>
      | Observable<{ [key: string]: any } | null> => {
      if (isEmptyInputValue(control.value)) {
        return of(null);
      } else if (control.value === initialEmail) {
        return of(null);
      } else {
        return control.valueChanges.pipe(
          debounceTime(500),
          take(1),
          switchMap(_ =>
            this.userService
              .getByEmail(control.value)
              .pipe(
                map(user =>
                  user ? { existingEmail: { value: control.value } } : null
                )
              )
          )
        );
      }
    };
  }

  patternValidatorPassword(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } | null => {
      if (!control.value) {
        return null;
      }
      const regex = new RegExp('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$');
      const valid = regex.test(control.value);
      return valid ? null : {invalidPassword: true};
    };
  }

  MatchPassword(password: string, confirmPassword: string) {
    // @ts-ignore
    return (formGroup: FormGroup) => {
      const passwordControl = formGroup.controls[password];
      const confirmPasswordControl = formGroup.controls[confirmPassword];

      if (!passwordControl || !confirmPasswordControl) {
        return null;
      }

      if (confirmPasswordControl.errors && !confirmPasswordControl.errors.passwordMismatch) {
        return null;
      }

      if (passwordControl.value !== confirmPasswordControl.value) {
        confirmPasswordControl.setErrors({passwordMismatch: true});
      } else {
        confirmPasswordControl.setErrors(null);
      }
    }
  }
}

function isEmptyInputValue(value: any): boolean {
  // we don't check for string here so it also works with arrays
  return value === null || value.length === 0;
}
