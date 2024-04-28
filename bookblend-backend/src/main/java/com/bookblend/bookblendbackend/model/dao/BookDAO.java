package com.bookblend.bookblendbackend.model.dao;

import com.bookblend.bookblendbackend.model.Book;
import org.springframework.data.repository.ListCrudRepository;

//Data Access Object for accessing Book data.

public interface BookDAO extends ListCrudRepository<Book, Long> {
}