package com.example.book_store.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter

@Entity
@Table(name = "books")
public class BooksEntity {
    @Id
    @Column(name = "book_id")
    private String bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stock")
    private int stock;

    @Column(name = "category")
    private String category;

    @Column(name = "types")
    private String types;

    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "height_thickness")
    private String height_thickness;

    @Column(name = "pages")
    private String pages;

    @Column(name = "language")
    private String language;

    @Column(name = "size")
    private String size;

    @Column(name = "date")
    private LocalDate date;
}
