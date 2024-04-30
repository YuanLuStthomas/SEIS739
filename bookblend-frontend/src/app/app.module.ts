import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';


import { AppComponent } from './app.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { HomeComponentComponent } from './components/home-component/home-component.component';
import { BookListComponent } from './components/book-list/book-list.component';
import { AboutUsPageComponent } from './components/about-us-page/about-us-page.component';


const appRoutes: Routes = [
  { path: '', component: HomeComponentComponent },
  { path: 'users', component: UserListComponent },
  { path: 'books', component: BookListComponent },
  { path: 'about', component: AboutUsPageComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    HomeComponentComponent,
    BookListComponent,
    AboutUsPageComponent
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
