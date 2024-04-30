import { Component, OnInit } from '@angular/core';
import { Book } from '../../model/book';
import { BookServiceService } from '../../services/book-service.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrl: './book-list.component.scss'
})
export class BookListComponent implements OnInit {

  books: Book[] = [];

  constructor(private bookService: BookServiceService) { }

  ngOnInit(): void {
    this.bookService.findAll().subscribe(data => this.books = data);
  }

}
