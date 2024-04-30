import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Book } from '../model/book';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {

  private booksUrl: string;

  constructor(private http:HttpClient) {
    this.booksUrl = 'http://localhost:8080/book';
  }

  public findAll(): Observable<Book[]> {
    return this.http.get<Book[]>(this.booksUrl);
  }

  getBook(id: number | string) {
    return this.findAll().pipe(
      // (+) before `id` turns the string into a number
      map((books: Book[]) => books.find(book => book.id === +id)!)
    );
  }

  public save(book: Book) {
    return this.http.post<Book>(this.booksUrl, book);
  }
}
