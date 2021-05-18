// @ts-ignore
import { NgModule } from '@angular/core';
// @ts-ignore
import { RouterModule, Routes } from '@angular/router';
import {RegistrationComponent} from './components/registration/registration.component';
import {ProfileInformationComponent} from './profile-information/profile-information.component';

const routes: Routes = [
  { path: 'registration', component: RegistrationComponent },
  { path: 'user/:id', component: ProfileInformationComponent }
];

// @ts-ignore
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
