
import { NgModule } from '@angular/core';

import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {HttpClientModule} from '@angular/common/http';
import { RegistrationComponent } from './components/user/registration/registration.component';

import {ReactiveFormsModule} from '@angular/forms';

import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './components/navigation/header/header.component';
import { FooterComponent } from './components/navigation/footer/footer.component';
import { ProfileInformationComponent } from './components/user/profile/profile-information/profile-information.component';
import { ProfileComponent } from './components/user/profile/profile.component';
import { BecomeCoachComponent } from './components/user/profile/become-coach/become-coach.component';
import { HomeComponent } from './components/navigation/home/home.component';
import { CoachSessionsComponent } from './components/user/profile/coach-sessions/coach-sessions.component';
import { FindCoachComponent } from './components/user/profile/find-coach/find-coach.component';


@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    HeaderComponent,
    FooterComponent,
    ProfileInformationComponent,
    ProfileComponent,
    BecomeCoachComponent,
    HomeComponent,
    CoachSessionsComponent,
    FindCoachComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
