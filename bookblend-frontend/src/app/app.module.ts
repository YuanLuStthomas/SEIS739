import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';


import { AppComponent } from './app.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
//import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { HomeComponentComponent } from './components/home-component/home-component.component';
import { BookListComponent } from './components/book-list/book-list.component';
import { AboutUsPageComponent } from './components/about-us-page/about-us-page.component';
import { FooterComponent } from './components/footer/footer.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { BookComponent } from './components/book/book.component';
import { PageNotFoundComponentComponent } from './components/page-not-found-component/page-not-found-component.component';
import { SearchPageComponent } from './components/search-page/search-page.component';


const appRoutes: Routes = [
  { path: '', component: HomeComponentComponent },
  { path: 'users', component: UserListComponent },
  { path: 'books', component: BookListComponent },
  { path: 'book/:id', component: BookComponent},
  { path: 'about', component: AboutUsPageComponent },
  { path: 'search', component: SearchPageComponent },
  { path: '**', component: PageNotFoundComponentComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    HomeComponentComponent,
    BookListComponent,
    AboutUsPageComponent,
    FooterComponent,
    NavbarComponent,
    BookComponent,
    PageNotFoundComponentComponent,
    SearchPageComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes, { enableTracing: true })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
