import { Component, Input } from '@angular/core';
import { Book } from '../../model/book';
import { BookServiceService } from '../../services/book-service.service';

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrl: './search-page.component.scss'
})
export class SearchPageComponent {
  public search: string;
  public submit: string;

  [x: string]: any;

  books: Book[] = [];

  constructor(private bookService: BookServiceService) { }

  ngOnInit(): void {
    this.bookService.findAll().subscribe((books) => this.books = books);
  }

  onSearch(){
    if(!this.search){
      // console.log('something is happening??');
      alert('The required fields have not all been filled for submitting a search for an artist!');
      return;
    }
  }
}
