import { Component, inject } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { BookServiceService } from '../../services/book-service.service';
import { Book } from '../../model/book';
import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrl: './book.component.scss'
})
export class BookComponent {

  // wanted to make sure my activated route from the home & Explore components were working 
  // so I added this artistId property to the artist-page component
  // and then added the artistId to the artist-page.component.html file
  // referenced this video on how to do it: https://www.youtube.com/watch?v=r5DEBMuStPw

  bookId: number = 0;

  book$!: Observable<Book>;

  route: ActivatedRoute = inject(ActivatedRoute);


  constructor(private bookService: BookServiceService, private router: Router) {
      this.bookId = Number(this.route.snapshot.paramMap.get('id'));
      this.book$ = this.route.paramMap.pipe(
         switchMap((params: ParamMap) =>
            this.bookService.getBook(params.get('id')!))
      )
   }

}
