package com.bookblend.bookblendbackend.service;

import com.bookblend.bookblendbackend.model.Book;
import com.bookblend.bookblendbackend.model.dao.BookDAO;
import org.springframework.stereotype.Service;

import java.util.List;

//Service for handling book actions.
@Service
public class BookService {

  /** The book DAO. */
  private BookDAO bookDAO;

  /**
   * Constructor for spring injection.
   * @param bookDAO
   */
  public BookService(BookDAO bookDAO) {
    this.bookDAO = bookDAO;
  }

  /**
   * Gets the all books available.
   * @return The list of books.
   */
  public List<Book> getBooks() {
    return bookDAO.findAll();
  }

}