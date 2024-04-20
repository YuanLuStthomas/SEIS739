package com.bookblend.bookblendbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Inventory of a book that available for purchase.
 */
@Entity
@Table(name = "inventory")
public class Inventory {

    /** Unique id for the inventory. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /** The book this inventory is of. */
    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "book_id", nullable = false, unique = true)
    private Book book;

    /** The quantity in stock. */
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    /**
     * Gets the quantity in stock.
     * @return The quantity.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity in stock of the book.
     * @param quantity The quantity to be set.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the book.
     * @return The book.
     */
    public Book getBook() {
        return book;
    }

    /**
     * Sets the book.
     * @param book The book to be set.
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * Gets the ID of the inventory.
     * @return The ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the inventory.
     * @param id The ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

}