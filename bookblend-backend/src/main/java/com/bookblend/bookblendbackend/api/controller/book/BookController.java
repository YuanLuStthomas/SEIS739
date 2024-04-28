package com.bookblend.bookblendbackend.api.controller.book;

import com.bookblend.bookblendbackend.model.Book;
import com.bookblend.bookblendbackend.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    /**
     * Controller to handle the creation, updating & viewing of Books.
     */
    @RestController
    @RequestMapping("/book")
    public class BookController {

        /** The Book Service. */
        private BookService bookService;

        /**
         * Constructor for spring injection.
         * @param bookService
         */
        public BookController(BookService bookService) {
            this.bookService = bookService;
        }

        /**
         * Gets the list of books available.
         * @return The list of books.
         */
        @GetMapping
        public List<Book> getBooks() {
            return bookService.getBooks();
        }

}