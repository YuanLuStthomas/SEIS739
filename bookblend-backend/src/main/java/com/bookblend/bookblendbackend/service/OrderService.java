package com.bookblend.bookblendbackend.service;

import com.bookblend.bookblendbackend.model.LocalUser;
import com.bookblend.bookblendbackend.model.BookOrder;
import com.bookblend.bookblendbackend.model.dao.BookOrderDAO;
import org.springframework.stereotype.Service;

import java.util.List;

//Service for handling order actions.
@Service
public class OrderService {

    //The Web Order DAO
  private BookOrderDAO bookOrderDAO;

  /**
   * Constructor for spring injection.
   * @param bookOrderDAO
   */
  public OrderService(BookOrderDAO bookOrderDAO) {
    this.bookOrderDAO = bookOrderDAO;
  }

  /**
   * Gets the list of orders for a given user.
   * @param user The user to search for.
   * @return The list of orders.
   */
  public List<BookOrder> getOrders(LocalUser user) {
    return bookOrderDAO.findByUser(user);
  }

}