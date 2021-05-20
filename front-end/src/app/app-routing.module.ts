import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import {RegistrationComponent} from './components/registration/registration.component';
import {ProfileInformationComponent} from './profile/profile-information/profile-information.component';
import {ProfileComponent} from './profile/profile.component';
import {BecomeCoachComponent} from './profile/become-coach/become-coach.component';

const routes: Routes = [
  { path: 'registration', component: RegistrationComponent },
  { path: 'user/:id', component: ProfileComponent ,
    children: [
      {path: 'profile-info', component: ProfileInformationComponent },
      {path: 'become-coach', component: BecomeCoachComponent},
    ]}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
