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


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'log', component: LoginComponent},
  {path: 'find-coach', component: FindCoachComponent},
  {
    path: 'user/:id', component: ProfileComponent,
    children: [
      {path: 'profile-information', component: ProfileInformationComponent},
      {path: 'become-coach', component: BecomeCoachComponent},
      {path: 'coach-sessions', component: CoachSessionsComponent}
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
