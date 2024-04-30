import { Component, OnInit } from '@angular/core';
import { Book } from '../../model/book';
import { BookServiceService } from '../../services/book-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrl: './book-list.component.scss'
})
export class BookListComponent implements OnInit {

  [x: string]: any;

  books: Book[] = [];

  constructor(private bookService: BookServiceService, private router: Router) { }

  ngOnInit(): void {
    this.bookService.findAll().subscribe(data => this.books = data);
  }

  navigateToArtist(bookId: number): void {
    this.router.navigate(['/book', bookId]);
  }

}
