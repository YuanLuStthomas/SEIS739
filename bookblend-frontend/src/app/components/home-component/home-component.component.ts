import { Component } from '@angular/core';
import { BookServiceService } from '../../services/book-service.service';
import { Book } from '../../model/book';

@Component({
  selector: 'app-home-component',
  templateUrl: './home-component.component.html',
  styleUrl: './home-component.component.scss'
})
export class HomeComponentComponent {

  books: Book[] = [];

  constructor(private bookService: BookServiceService) { }

  ngOnInit(): void {
    this.bookService.findAll().subscribe(data => this.books = data);
  }

}
