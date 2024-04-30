package com.bookblend.bookblendbackend.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * A book available for purchasing.
 */
@Entity
@Table(name = "book")
public class Book {

    /** Unique id for the book. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    /** The name of the book. */
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    /** The name of the book. */
    @Column(name = "author", nullable = false)
    private String author;

    /** The name of the book. */
    @Column(name = "book_img", nullable = false)
    private String bookImg;

    /** The short description of the book. */
    @Column(name = "short_description", nullable = false)
    private String shortDescription;

    /** The long description of the book. */
    @Column(name = "long_description")
    private String longDescription;

    /** The price of the book. */
    @Column(name = "price", nullable = false)
    private Double price;

    /** The inventory of the book. */
    @OneToOne(mappedBy = "book", cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
    private Inventory inventory;

    /**
     * Gets the inventory of the book.
     * @return The inventory.
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Sets the inventory of the book.
     * @param inventory The inventory.
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Gets the price of the book.
     * @return The price.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the price of the book.
     * @param price The price.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets the long description of the book.
     * @return The long description.
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * Sets the long description of the book.
     * @param longDescription The long description.
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    /**
     * Gets the short description of the book.
     * @return The short description.
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Sets the short description of the book.
     * @param shortDescription The short description.
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * Gets the name of the book.
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the book.
     * @param name The name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the author of the book.
     * @return The author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     * @param author The author.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the book_img of the book.
     * @return The bookImg.
     */
    public String getBookImg() {
        return bookImg;
    }

    /**
     * Sets the book_img of the book.
     * @param bookImg The book_img.
     */
    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    /**
     * Gets the id of the book.
     * @return The id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the book.
     * @param id The id.
     */
    public void setId(Long id) {
        this.id = id;
    }

}