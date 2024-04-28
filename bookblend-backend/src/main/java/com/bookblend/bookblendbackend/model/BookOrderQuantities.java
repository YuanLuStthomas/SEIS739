package com.bookblend.bookblendbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * The quantity ordered of a book.
 */
@Entity
@Table(name = "book_order_quantities")
public class BookOrderQuantities {

    /** The unqiue id of the order quantity. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /** The book being ordered. */
    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    /** The quantity being ordered. */
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    /** The order itself. */
    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private BookOrder order;

    /**
     * Gets the order.
     * @return The order.
     */
    public BookOrder getOrder() {
        return order;
    }

    /**
     * Sets the order.
     * @param order The order.
     */
    public void setOrder(BookOrder order) {
        this.order = order;
    }

    /**
     * Gets the quantity ordered.
     * @return The quantity.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity ordered.
     * @param quantity The quantity.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the book ordered.
     * @return The book.
     */
    public Book getBook() {
        return book;
    }

    /**
     * Sets the book.
     * @param book The book.
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * Gets the id.
     * @return The id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     * @param id The id.
     */
    public void setId(Long id) {
        this.id = id;
    }

}