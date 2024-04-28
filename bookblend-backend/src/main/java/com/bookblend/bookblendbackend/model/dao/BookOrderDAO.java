package com.bookblend.bookblendbackend.model.dao;

import com.bookblend.bookblendbackend.model.LocalUser;
import com.bookblend.bookblendbackend.model.BookOrder;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

/**
 * Data Access Object to access BookOrder data.
 */
public interface BookOrderDAO extends ListCrudRepository<BookOrder, Long> {

  List<BookOrder> findByUser(LocalUser user);

}