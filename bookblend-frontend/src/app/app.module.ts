import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';


import { AppComponent } from './app.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { HomeComponentComponent } from './components/home-component/home-component.component';


const appRoutes: Routes = [
  { path: '', component: HomeComponentComponent },
  { path: 'users', component: UserListComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    HomeComponentComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, { enableTracing: true })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
