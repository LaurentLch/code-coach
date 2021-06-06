// @ts-ignore
import {NgModule} from '@angular/core';

// @ts-ignore
import {RouterModule, Routes} from '@angular/router';
import {RegistrationComponent} from './components/user/registration/registration.component';
import {ProfileInformationComponent} from './components/user/profile/profile-information/profile-information.component';
import {ProfileComponent} from './components/user/profile/profile.component';
import {BecomeCoachComponent} from './components/user/profile/become-coach/become-coach.component';
import {HomeComponent} from './components/navigation/home/home.component';
import {CoachSessionsComponent} from './components/user/profile/coach-sessions/coach-sessions.component';
import {FindCoachComponent} from './components/user/Find-Coach/find-coach/find-coach.component';
import {LoginComponent} from './components/user/login/login.component';
import {CoachProfileComponent} from './components/user/Find-Coach/coach-profile/coach-profile.component';
import {EditProfileComponent} from './components/user/profile/edit-profile/edit-profile.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'log', component: LoginComponent},
  {path: 'coaches/:id/profile-information', component: CoachProfileComponent},
  {
    path: 'coaches', component: FindCoachComponent
  },
  {
    path: 'user/:id', component: ProfileComponent,
    children: [
      {path: 'profile-information', component: ProfileInformationComponent},
      {path: 'become-coach', component: BecomeCoachComponent},
      {path: 'coach-sessions', component: CoachSessionsComponent},
      {path: 'edit-profile', component: EditProfileComponent}
    ]
  }
];


// @ts-ignore
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
